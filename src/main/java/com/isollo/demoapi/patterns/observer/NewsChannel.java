package com.isollo.demoapi.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class NewsChannel implements Subject{
    private final List<Observer> subscribers;
    private String latestNews;

    public NewsChannel() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        this.subscribers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.subscribers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer subcriber: subscribers) {
            subcriber.update(this.latestNews);
        }
    }

    public void publishNews(String news) {
        this.latestNews = news;
        this.notifyObservers();
    }
}
