package com.dankeroni.dankbot;

import java.util.LinkedList;

public class DankHandler {

    public LinkedList<DankModule> dankModules = new LinkedList<>();

    public void checkChannelMessage(String message, String sender){
        for(DankModule dankModule : dankModules){
            if(message.toLowerCase().startsWith(dankModule.getCommand())) {
                dankModule.onChannelCommand(message, sender);
                break;
            }
        }
    }

    public void checkWhisperMessage(String message, String sender){
        for(DankModule dankModule : dankModules){
            if(message.toLowerCase().startsWith(dankModule.getCommand())){
                dankModule.onWhisperCommand(message, sender);
                break;
            }
        }
    }

    public void addModule(DankModule dankModule){
        dankModules.add(dankModule);
    }

    public void removeModule(DankModule dankModule){
        dankModules.remove(dankModule);
    }

    public LinkedList<DankModule> getDankModules() {
        return dankModules;
    }
}