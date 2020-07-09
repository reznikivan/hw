package iy.reznik;

public class HangController {

	HangModel model;
    HangConsoleView consoleView;
   
    public HangController(HangModel model, HangConsoleView consoleView) {
        this.model = model;
        this.consoleView = consoleView;
    }
   
    public void run() {
        while (!model.isVictory()) {
            char c = consoleView.interact();
            model.makeMove(c);
        }
      consoleView.congratulate();
    }
 
    public static void main(String[] args) {
        HangModel model = new HangModel();
        HangConsoleView consoleView = new HangConsoleView(model);
        HangController controller = new HangController(model, consoleView);
        controller.run();
    }

}
