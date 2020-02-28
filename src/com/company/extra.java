package com.company;

public class extra {
    //        System.out.println(getAgeInSeconds());
//        for (int x = 0; x >one.bullet.length ; x++) {
//
//            for (int i = 0; i > EnemyArray.size(); i++) {
//
//                if(one.bullet[x].intersection(EnemyArray.get(i))) {
//                    EnemyArray.remove(i);
//                    System.out.println("HI");
//
//
//                }
//           }
//        }
//        ;
    //             eone.Enemy(x,y,50,50);
//             etwo.Enemy(x1,y1,50,50);
//             ethr.Enemy(x1,y1,50,50);
//             efor.Enemy(x1,y1,50,50);
//             efiv.Enemy(x1,y1,50,50);

//             pen.fillRect(inter.getX(),inter.getY(),inter.getWidth(),inter.getHeight());
//             pen.fillRect(inter2.getX(),inter2.getY(),inter2.getWidth(),inter2.getHeight());
//             pen.fillRect(inter3.getX(),inter3.getY(),inter3.getWidth(),inter3.getHeight());
//             pen.fillRect(inter4.getX(),inter4.getY(),inter4.getWidth(),inter4.getHeight());
//             pen.fillRect(inter5.getX(),inter5.getY(),inter5.getWidth(),inter5.getHeight());
    //    for (int i = 0; i < 1000; i++) {
//      BArray[i]=new Bullets(one.getX(),one.getY());
//      System.out.println(one.getX());
//      count1+=1;
//    }
//    for(int i=0;i<count1;i++){
//
//        BArray[i].draw(pen, Color.blaack);
// B
//    }
////    inter = one.intersection(eone);
    //     pen.setColor(Color.blue);
//   pen.fillRect(two.getX()+10,two.getY()+10 ,two.getWidth(),two.getHeight());




//        private Enemy eone = new Enemy ();
//        private Enemy etwo = new Enemy ();
//        private Enemy ethr = new Enemy ();
//        private Enemy efor = new Enemy ();
//        private Enemy efiv = new Enemy ();
//
//
//        }
}
//player

//    public Player intersection(Player rect){
//
////        System.out.println(this.getWidth());
//
//          int top=rect.getX()+rect.getWidth();
//          int bottom=rect.getY()+rect.getHeight();
//          int endX=0;
//          int endY=0;
//          boolean crossed = false;
//          for(int k=0;k<rect.getWidth()+1;k++){
//              for(int l=0;l<rect.getHeight()+1;l++){
//                  if(this.contains(rect.getX()+k,rect.getY()+l)){
//
//                    crossed=true;
//                    if(rect.getX()+k>endX){
//                        endX=rect.getX()+k;
//                    }
//                    if(rect.getY()+l>endY){
//                        endY=rect.getY()+l;
//                    }
//                    if(rect.getX()+k<top){
//                        top=rect.getX()+k;
//                    }
//                    if(rect.getY()+l<bottom){
//                        bottom=rect.getY()+l;
//                    }
//              }
//              }
//          }
//
//
//        Player newR=new Player();
//         if (crossed)
//            newR.Player(top,bottom,endX-top,endY-bottom);
//         else{
//            newR.(top,bottom,0,0);
//                }
//        return newR;
//    }
///?/// tile set
//        for (int i = 0; i < tileSet.size(); i++) {
//            if (tileSet.get(i) instanceof Wall || (tileSet.get(i) instanceof Door && !(two.getHasKey()))) {
//                if (tileSet.get(i).collideDown(two))
//                    two.setY(two.getY() - playerVelocity);
////                two.doFall = false;
//                if (tileSet.get(i).collideUp(two))
//                    two.setY(two.getY() + playerVelocity);
//
//                if (tileSet.get(i).collideLeft(two))
//                    two.setX(two.getX() + playerVelocity);
//                if (tileSet.get(i).collideRight(two))
//                    two.setX(two.getX() - playerVelocity);
//            } else if (tileSet.get(i) instanceof Key) {
//                if (tileSet.get(i).collideLeft(two) || tileSet.get(i).collideRight(two) || tileSet.get(i).collideUp(two) || tileSet.get(i).collideDown(two)) {
//                    tileSet.add(i + 1, new Air(tileSet.get(i).getX(), tileSet.get(i).getY(), 25, 25));
//                    tileSet.remove(i);
//                    two.setHasKey(true);
//                }
//            } else if (tileSet.get(i) instanceof Door) {
//                if (two.getHasKey() && (tileSet.get(i).collideLeft(two) || tileSet.get(i).collideRight(two) || tileSet.get(i).collideUp(two) || tileSet.get(i).collideDown(two))) {
//                    for (int door = 0; door < tileSet.size(); door++) {
//                        if (tileSet.get(door) instanceof Door) {
//                            tileSet.add(door + 1, new Air(tileSet.get(door).getX(), tileSet.get(door).getY(), 25, 25));
//                            tileSet.remove(door);
//                        }
//                    }
//                }
//            } else if (tileSet.get(i) instanceof Lava) {
//                if (tileSet.get(i).collideLeft(two) || tileSet.get(i).collideRight(two) || tileSet.get(i).collideUp(two) || tileSet.get(i).collideDown(two)) {
//                    room.clear();
//                    room.fillMap();
//                    two.setHasKey(false);
//                    for (int start = 0; start < tileSet.size(); start++) {
//                        if (tileSet.get(start) instanceof Start) {
//                            two.setX(((Start) tileSet.get(start)).getStartLocation()[0]);
//                            two.setY(((Start) tileSet.get(start)).getStartLocation()[1]);
//                        }
//                    }
//                }
//            } else if (tileSet.get(i) instanceof Exit) {
//                if (tileSet.get(i).collideLeft(two) || tileSet.get(i).collideRight(two) || tileSet.get(i).collideUp(two) || tileSet.get(i).collideDown(two)) {
//                    tileSet.remove(i);
//                    room.nextLevel();
//                    room.clear();
//                    room.fillMap();
//                    two.setHasKey(false);
//                    for (int start = 0; start < tileSet.size(); start++) {
//                        if (tileSet.get(start) instanceof Start) {
//                            two.setX(((Start) tileSet.get(start)).getStartLocation()[0]);
//                            two.setY(((Start) tileSet.get(start)).getStartLocation()[1]);
//                        }
//                    }
//                }
//            }
//        }
//