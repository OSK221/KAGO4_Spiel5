package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.Background;
import my_project.model.DeathScreen;
import my_project.model.enemy.Enemy;
import my_project.model.Player;
import my_project.model.enemy.Goblin;
import my_project.model.enemy.Knight;
import my_project.model.enemy.Skeleton;
import my_project.model.maze.Tilemap;

public class ProgramController {

    private ViewController viewController;

    private DeathScreen deathScreen = new DeathScreen();

    private Tilemap tilemap = new Tilemap();

    private Player player = new Player(600,450,tilemap,3.0);

    private Camera camera = new Camera(player);

    private Enemy[] enemies =  new Enemy[]{
            //Skeletons
            new Skeleton("SK_TopLeft", -1110.0, 90.0, player, tilemap),
            new Skeleton("SK_TopRight", -90.0, 90.0, player, tilemap),
            new Skeleton("SK_BottomRight", -90.0, 810.0, player, tilemap),
            new Skeleton("SK_BottomLeft", -1110.0, 810.0, player, tilemap),

            //Knight
            new Knight("Knight01",1500,300,player, tilemap),
            new Knight("Knight02",1500,600,player, tilemap),
            new Knight("Knight03",1500,-600,player, tilemap),
            new Knight("Knight04",1700,-600,player, tilemap),

            //Goblin
            new Goblin("Goblin01",600,-600,player,tilemap),
            new Goblin("Goblin02",600,-300,player,tilemap),
            new Goblin("Goblin03",-1100,-600,player,tilemap),
            new Goblin("Goblin04",-1100,-300,player,tilemap),
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