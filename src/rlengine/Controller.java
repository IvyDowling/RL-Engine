package rlengine;

import asciiPanel.AsciiCharacterData;
import asciiPanel.Render;
import asciiPanel.TileTransformer;

public class Controller {
    
    
    private static final Controller controller = new Controller();
    private static Screen screen;
    private Page page;
    
    public Controller() {
        screen = Screen.getInstance();
//        setPage(new Page());
    }

    public final void setPage(Page p) {
        this.clearDraws();
        page = p;
        screen.setBackgroundColor(page.getBackgroundColor());
        screen.setForegroundColor(page.getForegroundColor());
        screen.addAnimation(page.getDefaultAnimation());
        this.addDraw(page.getDefaultDraw());
    }

    public void transform(int x, int y, AsciiCharacterData data) {
        screen.transform(x, y, data);
    }

    public void render() {
        screen.render();
    }

    public void addAnimation(TileTransformer t) {
        screen.addAnimation(t);
    }

    public void addAnimation(TileTransformer[] t) {
        screen.addAnimation(t);
    }

    public void addDraw(Render r) {
        screen.addDraw(r);
    }

    public void addDraw(Render[] r) {
        screen.addDraw(r);
    }

    public void addDraw(Render[][] r) {
        screen.addDraw(r);
    }

    public void addDraw(AsciiCharacterData[][] r) {
        screen.addDraw(r);
    }

    private void execute(Command c) {
        if (c != null) {
            c.exe(getInstance());
        }
    }

    public void clearDraws() {
        screen.clearView();
    }

    public void takeInput(int keyCode) {
        execute(page.pageAction(keyCode));
//        switch (keyCode) {
//            case 65://a
//            case 37://left
//                break;
//            case 87://w
//            case 38://up
//                break;
//            case 68://d
//            case 39://right
//                break;
//            case 83://s
//            case 40://down
//                break;
//        }
    }

    public int getScreenWidth() {
        return screen.getAsciiPanelWidth();
    }

    public int getScreenHeight() {
        return screen.getAsciiPanelHeight();
    }

    public static Controller getInstance() {
        if (controller == null) {
            Controller controller = new Controller();
        }
        return controller;
    }
}
