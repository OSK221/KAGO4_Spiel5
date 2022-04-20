package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.Background;
import my_project.model.enemy.Enemy;
import my_project.model.Player;
import my_project.model.maze.Tilemap;
import my_project.view.InputManager;

import java.awt.*;

public class ProgramController {

    private final ViewController viewController;
    private final InputManager inputManager;

    private final Player player;

    private final Tilemap tilemap;

    private final Enemy e01;

    public ProgramController(ViewController viewController){
        tilemap = new Tilemap();
        viewController.draw(tilemap);
        tilemap.generateGrass(viewController);
        player = new Player(300,450,tilemap);
        viewController.draw(player);
        viewController.register(player);
        inputManager = new InputManager(this,player);
        viewController.register(inputManager);
        e01 = new Enemy("Test-Enemy",1400,-200,1,1,100,player, tilemap, Color.BLACK);
        viewController.draw(e01);
        viewController.draw(new Background());
        this.viewController = viewController;
    }
}