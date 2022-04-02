package my_project.model.maze;

import my_project.model.maze.tile.*;

public class Maze {

    public static void area(Tilemap tm, int area){
        switch (area){
            case 1: area01(tm); break;
            case 2: area02(tm); break;
            case 3: area03(tm); break;
            case 4: area04(tm); break;
            case 5: area05(tm); break;
            case 6: area06(tm); break;
        }
        tm.load();
    }

    private static void area01(Tilemap tm){
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 13; j++) {
                tm.add(new GroundTile(i+1,j+1));
            }
        }
        for (int i = 0; i < 20; i++) {
            tm.add(new WallTile(i,0));
            tm.add(new WallTile(i,14));
        }
        for (int i = 0; i < 4; i++) {
            tm.add(new WallTile(0,i+1));
            tm.add(new WallTile(0,i+10));
            tm.add(new WallTile(19,i+1));
            tm.add(new WallTile(19,i+10));
        }
        for (int i = 0; i < 5; i++) {
            tm.add(new GroundTile(0,i+5));
            tm.add(new GroundTile(19,i+5));
        }
    }

    private static void area02(Tilemap tm){
        for (int i = 0; i < 20; i++) {
            tm.add(new WallTile(i-20,0));
            tm.add(new WallTile(i-20,14));
        }
        for (int i = 0; i < 4; i++) {
            tm.add(new WallTile(-1,i+1));
            tm.add(new WallTile(-1,i+10));
        }
        for (int i = 0; i < 5; i++) {
            tm.add(new GroundTile(-1,i+5));
        }
        for (int i = 0; i < 13; i++) {
            tm.add(new WallTile(-20,i+1));
        }
        for (int i = 0; i < 4; i++) {
            tm.add(new GraveTile(-16+i,4));
            tm.add(new GraveTile(-16+i,9));
            tm.add(new GraveTile(-8+i,4));
            tm.add(new GraveTile(-8+i,9));
            tm.add(new BlockTile(-16+i,5));
            tm.add(new BlockTile(-16+i,10));
            tm.add(new BlockTile(-8+i,5));
            tm.add(new BlockTile(-8+i,10));
        }
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 3; j++) {
                tm.add(new GroundTile(i - 19, 1+j));
                tm.add(new GroundTile(i - 19, 11+j));
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                tm.add(new GroundTile(i - 19, 4+j));
                tm.add(new GroundTile(i - 4, 4+j));
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                tm.add(new GroundTile(i - 12, 4+j));
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                tm.add(new GroundTile(i - 16, 6+j));
                tm.add(new GroundTile(i - 8, 6+j));
            }
        }
    }

    private static void area03(Tilemap tm){
        for (int i = 0; i < 5; i++) {
            tm.add(new WallTile(20,i));
            tm.add(new WallTile(20,i+10));
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                tm.add(new WaterTile(35+j,i));
            }
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 4; j++) {
                tm.add(new SandTile(31+j,i));
            }
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                tm.add(new GroundTile(21+j,i));
            }
        }
        for (int i = 0; i < 5; i++) {
            tm.add(new GroundTile(20,i+5));
        }
    }

    private static void area04(Tilemap tm){
        for (int i = 0; i < 5; i++) {
            tm.add(new TreeTile(20,i-15));
            tm.add(new TreeTile(20,i-5));
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                tm.add(new WaterTile(35+j,i-15));
            }
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 4; j++) {
                tm.add(new SandTile(31+j,i-15));
            }
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                tm.add(new GroundTile(21+j,i-15));
            }
        }
        for (int i = 0; i < 5; i++) {
            tm.add(new GroundTile(20,i-10));
        }
    }

    private static void area05(Tilemap tm){
        for (int i = 0; i < 20; i++) {
            tm.add(new TreeTile(i,-15));
            tm.add(new TreeTile(i,-1));
        }
        for (int i = 0; i < 4; i++) {
            tm.add(new TreeTile(19,i-14));
            tm.add(new TreeTile(19,i-5));
        }
        for (int i = 0; i < 5; i++) {
            tm.add(new GroundTile(19,i-10));
        }
        for (int i = 0; i < 13; i++) {
            tm.add(new GroundTile(0,i-14));
        }
        for (int i = 0; i < 4; i++) {
            tm.add(new TreeTile(4+i,4-15));
            tm.add(new TreeTile(4+i,9-15));
            tm.add(new TreeTile(-8+i+20,4-15));
            tm.add(new TreeTile(-8+i+20,9-15));
            tm.add(new TreeTile(-16+i+20,5-15));
            tm.add(new TreeTile(-16+i+20,10-15));
            tm.add(new TreeTile(-8+i+20,5-15));
            tm.add(new TreeTile(-8+i+20,10-15));
        }
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 3; j++) {
                tm.add(new GroundTile(i - 19+20, 1+j-15));
                tm.add(new GroundTile(i - 19+20, 11+j-15));
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                tm.add(new GroundTile(i - 19+20, 4+j-15));
                tm.add(new GroundTile(i - 4+20, 4+j-15));
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                tm.add(new GroundTile(i - 12+20, 4+j-15));
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                tm.add(new GroundTile(i - 16+20, 6+j-15));
                tm.add(new GroundTile(i - 8+20, 6+j-15));
            }
        }
    }

    private static void area06(Tilemap tm){
        for (int i = 0; i < 20; i++) {
            tm.add(new TreeTile(i-20,-15));
            tm.add(new TreeTile(i-20,-1));
        }
        for (int i = 0; i < 13; i++) {
            tm.add(new TreeTile(-20,i-14));
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                tm.add(new TreeTile(4+i-20,4+j-15));
                tm.add(new TreeTile(-8+i,4+j-15));
            }
        }
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 3; j++) {
                tm.add(new GroundTile(i - 19, 1+j-15));
                tm.add(new GroundTile(i - 19, 11+j-15));
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                tm.add(new GroundTile(i - 19, 4+j-15));
                tm.add(new GroundTile(i - 4, 4+j-15));
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                tm.add(new GroundTile(i - 12, 4+j-15));
            }
        }
        for (int i = 0; i < 13; i++) {
            tm.add(new GroundTile(-1,i-14));
        }
    }
}