package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.Background;
import my_project.model.enemy.Enemy;
import my_project.model.Player;
import my_project.model.enemy.Knight;
import my_project.model.enemy.Skeleton;
import my_project.model.maze.Tilemap;
import my_project.view.InputManager;

import java.awt.*;

public class ProgramController {

    private final ViewController viewController;
    private final InputManager inputManager;

    private final Tilemap tilemap = new Tilemap();

    private final Player player = new Player(300,450,tilemap);;

    private final Enemy[] enemies =  new Enemy[]{
            //Skeletons
            new Skeleton("SK_TopLeft", -1110.0, 90.0, 5, 2, 20, player, tilemap),
            new Skeleton("SK_TopRight", -90.0, 90.0, 5, 2, 20, player, tilemap),
            new Skeleton("SK_BottomRight", -90.0, 810.0, 5, 2, 20, player, tilemap),
            new Skeleton("SK_BottomLeft", -1110.0, 810.0, 5, 2, 20, player, tilemap),

            //Test
            new Knight("Test-Enemy",1400,-200,1,1,100,player, tilemap)

    };

    public ProgramController(ViewController viewController){
        viewController.draw(tilemap);
        tilemap.generateGrass(viewController);
        viewController.draw(player);
        viewController.register(player);
        inputManager = new InputManager(this,player);
        viewController.register(inputManager);
        for(Enemy en : enemies) viewController.draw(en);
        viewController.draw(new Background());
        this.viewController = viewController;
    }
}