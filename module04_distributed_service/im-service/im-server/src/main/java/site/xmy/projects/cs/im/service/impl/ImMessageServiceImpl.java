package site.xmy.projects.cs.im.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.xmy.projects.cs.im.entity.ImMessage;
import site.xmy.projects.cs.im.mapper.ImMessageMapper;
import site.xmy.projects.cs.im.service.ImMessageService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ImMessageServiceImpl extends ServiceImpl<ImMessageMapper, ImMessage> implements ImMessageService {
    ExecutorService pool = Executors.newFixedThreadPool(2);

    @Override
    public void saveMessage(ImMessage imMessage) {
//        pool.submit(new ImMessageTask(imMessage));

        pool.submit(new Runnable() {
            @Override
            public void run() {
                save(imMessage);
            }
        });
    }

    private class ImMessageTask implements Runnable {
        private ImMessage imMessage;
        public ImMessageTask(ImMessage imMessage) {
            this.imMessage = imMessage;
        }

        @Override
        public void run() {
            saveMessage(imMessage);
        }
    }
}
