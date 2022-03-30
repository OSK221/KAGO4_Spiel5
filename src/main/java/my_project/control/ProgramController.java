package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.Background;
import my_project.model.EnemyBase;
import my_project.model.Player;
import my_project.model.maze.Tilemap;
import my_project.view.InputManager;

public class ProgramController {

    private ViewController viewController;
    private InputManager inputManager;

    public Player player;

    private Tilemap tilemap;

    private EnemyBase eb;

    public ProgramController(ViewController viewController){
        tilemap = new Tilemap();
        viewController.draw(tilemap);
        player = new Player(600,450);
        viewController.draw(player);
        inputManager = new InputManager(this,player);
        viewController.register(inputManager);
        eb = new EnemyBase(1,"1",1,1,1,1,player);
        viewController.draw(eb);
        viewController.draw(new Background());
        this.viewController = viewController;
    }
}