package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.Background;
import my_project.model.DeathScreen;
import my_project.model.enemy.Enemy;
import my_project.model.Player;
import my_project.model.enemy.Knight;
import my_project.model.enemy.Skeleton;
import my_project.model.maze.Tilemap;

public class ProgramController {

    private ViewController viewController;

    private DeathScreen deathScreen = new DeathScreen();

    private Tilemap tilemap = new Tilemap();

    private Player player = new Player(300,450,tilemap,3.0);

    private Camera camera = new Camera(player);

    private Enemy[] enemies =  new Enemy[]{
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
        viewController.draw(camera);
        viewController.register(camera);
        for (Enemy en : enemies) {
            viewController.draw(en);
            viewController.register(en);
        }
        viewController.draw(new Background());
        this.viewController = viewController;
    }
}