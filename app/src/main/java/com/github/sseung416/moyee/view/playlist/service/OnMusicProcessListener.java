package com.github.sseung416.moyee.view.playlist.service;

// TODO: 2022-12-06 rename
public interface OnMusicProcessListener {

    void processPauseRequest();

    void processPlayRequest();

    void processSkipPreviousRequest();

    void processSkipNextRequest();

}
