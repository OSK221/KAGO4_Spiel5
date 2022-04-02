package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.Background;
import my_project.model.enemy.Enemy;
import my_project.model.Player;
import my_project.model.maze.Tilemap;
import my_project.view.InputManager;

public class ProgramController {

    private ViewController viewController;
    private InputManager inputManager;

    public Player player;

    private Tilemap tilemap;

    private Enemy e01;

    public ProgramController(ViewController viewController){
        tilemap = new Tilemap();
        viewController.draw(tilemap);
        player = new Player(300,450);
        viewController.draw(player);
        inputManager = new InputManager(this,player);
        viewController.register(inputManager);
        e01 = new Enemy("Test-Enemy",1000,600,1,1,100,player, tilemap);
        viewController.draw(e01);
        viewController.draw(new Background());
        this.viewController = viewController;
    }
}