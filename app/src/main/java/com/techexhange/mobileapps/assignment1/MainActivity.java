package com.techexhange.mobileapps.assignment1;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private NumSlider game;
    private ImageView one,two,three,four,five,six,seven,eight,zero;
   // private Map<ImageView, Integer> coordinatesMap;
    //private Map<Integer, Tuple> inverseCoordinates;
    private Bitmap spritesheet;
    private ImageView[] imagesGroup = new ImageView[9];
    //private Tuple[] imagesViewGroup = new Tuple[9];
    private Bitmap[] sprites = new Bitmap[9];
    boolean[] directions = new boolean[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spritesheet = BitmapFactory.decodeResource(this.getResources(),R.drawable.numbers_sprite_100);

        Bitmap sprite0 = Bitmap.createBitmap(spritesheet,0,0,2,20); sprites[0] = sprite0;
        Bitmap sprite = Bitmap.createBitmap(spritesheet,300,0,300,300); sprites[1]=sprite;
        Bitmap sprite2 = Bitmap.createBitmap(spritesheet,600,0,300,300);sprites[2]=sprite2;
        Bitmap sprite3 = Bitmap.createBitmap(spritesheet,900,0,300,300);sprites[3]=sprite3;
        Bitmap sprite4 = Bitmap.createBitmap(spritesheet,1200,0,300,300);sprites[4]=sprite4;
        Bitmap sprite5 = Bitmap.createBitmap(spritesheet,1500,0,300,300);sprites[5]=sprite5;
        Bitmap sprite6 = Bitmap.createBitmap(spritesheet,1800,0,300,300);sprites[6]=sprite6;
        Bitmap sprite7 = Bitmap.createBitmap(spritesheet,2100,0,300,300);sprites[7]=sprite7;
        Bitmap sprite8 = Bitmap.createBitmap(spritesheet,2400,0,300,300);sprites[8]=sprite8;

        game = new NumSlider();
       // coordinatesMap = new HashMap<ImageView, Integer>();
       // inverseCoordinates = new HashMap<Integer, Tuple>();

        one =findViewById(R.id.one_image);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directions=game.swapTile(1,0);
                swappingImages(directions, 1, 0);
            }
        });
        //imagesViewGroup[1]= new Tuple(one,1,sprite);
        imagesGroup[1]=one;

        two =findViewById(R.id.two_image);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directions=game.swapTile(2,0);
                swappingImages(directions, 2, 0);
            }
        });
        //imagesViewGroup[2]= new Tuple(two,2,sprite2);
        imagesGroup[2]=two;

        three =findViewById(R.id.three_image);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directions=game.swapTile(0,1);
                swappingImages(directions, 0, 1);
            }
        });
        //imagesViewGroup[3]= new Tuple(three,3,sprite3);
        imagesGroup[3]=three;

        four = findViewById(R.id.four_image);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directions=game.swapTile(1,1);
                swappingImages(directions, 1, 1);
            }
        });
       // imagesViewGroup[4]= new Tuple(four,4,sprite4);
        imagesGroup[4]=four;

        five = findViewById(R.id.five_image);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directions=game.swapTile(2,1);
                swappingImages(directions, 2, 1);
            }
        });
        //imagesViewGroup[5]= new Tuple(five,5,sprite5);
        imagesGroup[5]=five;

        six = findViewById(R.id.six_image);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directions=game.swapTile(0,2);
                swappingImages(directions, 0, 2);
            }
        });
        //imagesViewGroup[6]= new Tuple(six,6,sprite6);
        imagesGroup[6]=six;

        seven = findViewById(R.id.seven_image);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directions=game.swapTile(1,2);
                swappingImages(directions, 1, 2);
            }
        });
        //imagesViewGroup[7]= new Tuple(seven,7,sprite7);
        imagesGroup[7]=seven;

        eight = findViewById(R.id.eight_image);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directions = game.swapTile(2,2);
                swappingImages(directions, 2, 2);
            }
        });
        //imagesViewGroup[8]= new Tuple(eight,8,sprite8);
        imagesGroup[8]=eight;

        zero = findViewById(R.id.zero_image);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directions= game.swapTile(0,0);
                swappingImages(directions, 0, 0);
            }
        });
        //zero.setVisibility(View.INVISIBLE);
       // imagesViewGroup[0]= new Tuple(zero,0,sprite0);
        imagesGroup[0]=zero;





        //coordinatesMap.put(one,1); inverseCoordinates.put(1,new Tuple(one,1,sprite));
        //coordinatesMap.put(two,2); inverseCoordinates.put(2,new Tuple(two,2,sprite2));
        //coordinatesMap.put(three,3); inverseCoordinates.put(3,new Tuple(three,3,sprite3));
        //coordinatesMap.put(four,4); inverseCoordinates.put(4,new Tuple(four,4,sprite4));
        //coordinatesMap.put(five,5); inverseCoordinates.put(5,new Tuple(five,5,sprite5));
        //coordinatesMap.put(six,6); inverseCoordinates.put(6, new Tuple(six,6,sprite6));
        //coordinatesMap.put(seven,7); inverseCoordinates.put(7, new Tuple(seven,7,sprite7));
        //coordinatesMap.put(eight,8); inverseCoordinates.put(8,new Tuple(eight,8,sprite8));
        //coordinatesMap.put(zero,0); inverseCoordinates.put(0,new Tuple(zero,0,sprite0));
        loadGames();
    }


    private void swappingImages(boolean[] directions, int column, int row ){
        int oldPosition = (row*3) + column;
        System.out.println("Old Position: "+ oldPosition);

        int newPosition = this.getCoordinate(oldPosition, directions);
        System.out.println("New Position: "+ newPosition);
        if(newPosition<9){
            //imagesGroup[newPosition].setImageBitmap(sprites[oldPosition]);
            imagesGroup[newPosition].setVisibility(View.VISIBLE);
           // imagesGroup[newPosition].setImageDrawable(null);
            System.out.println("GRIDDDDD: "+ NumSlider.gridTiles[row][column].getTileValue());
            imagesGroup[newPosition].setImageBitmap(sprites[ NumSlider.gridTiles[newPosition/3][newPosition%3].getTileValue()]);
            imagesGroup[oldPosition].setVisibility(View.INVISIBLE);
            //imagesGroup[newPosition].setVisibility(View.INVISIBLE)

        }
        Boolean wonStatus = game.checkIfWon();
        if(wonStatus) this.won();
    }
    //private void onImagePressed(View v, int index){

        //--int oldPosition = coordinatesMap.get(v);
        //--System.out.println("POSITION:  " + oldPosition);
       //-- int row = (coordinatesMap.get(v))/3;
       //-- int column = (coordinatesMap.get(v))%3;
       //-- System.out.println("Testing: "+ oldPosition+" Row: "+row+"Column"+column);
       //-- boolean[] directions = game.swapTile(column,row);
       //int newPosition = this.getCoordinate(coordinatesMap.get(v),directions); //Int position to move
       //-- if (newPosition<9){

            //ImageView oldImage = inverseCoordinates.get(coordinatesMap.get(v)).getImage();

        //--    coordinatesMap.replace((ImageView) v,newPosition);
        //--    coordinatesMap.replace(inverseCoordinates.get(newPosition).getImage(), oldPosition);


            //Bitmap oldBitmap = inverseCoordinates.get(coordinatesMap.get(v)).getBitmap();
            //inverseCoordinates.get(newPosition).setBitmap(oldBitmap);
            //ImageView toMove = inverseCoordinates.get(coordinatesMap.get(v)).getImage(); //The number of the image
            //ImageView NewImage = inverseCoordinates.get(newPosition).getImage();
            //NewImage.setImageBitmap(inverseCoordinates.get(coordinatesMap.get(toMove)).getBitmap());

            //toMove.setVisibility(View.INVISIBLE);
            //NewImage.setVisibility(View.VISIBLE);
      //  }
        //Boolean wonStatus = game.checkIfWon();
        //if(wonStatus) this.won();
        //return v;
   // }

    private int getCoordinate(int number, boolean[] directions){
        int result=9;
        for(int i=0;i<directions.length;i++){
            if(directions[i]){
                if(i==0){//toRight
                    result = number +1;
                }
                else if(i==1){//toLeft
                    result = number -1;
                }
                else if(i==2){//up
                    result=number-3;
                }
                else{//down
                    result=number+3;
                }
            }
        }
        return result;
    }

    private void won(){
        changeBitMapsColor();
        Toast.makeText(MainActivity.this, "CONGRATS YOU WON!", Toast.LENGTH_SHORT).show();


    }

    private void changeBitMapsColor(){
        Bitmap green = Bitmap.createBitmap(spritesheet,300,600,300,300);
        Bitmap green2 = Bitmap.createBitmap(spritesheet,600,600,300,300);
        Bitmap green3 = Bitmap.createBitmap(spritesheet,900,600,300,300);
        Bitmap green4 = Bitmap.createBitmap(spritesheet,1200,600,300,300);
        Bitmap green5 = Bitmap.createBitmap(spritesheet,1500,600,300,300);
        Bitmap green6 = Bitmap.createBitmap(spritesheet,1800,600,300,300);
        Bitmap green7 = Bitmap.createBitmap(spritesheet,2100,600,300,300);
        Bitmap green8 = Bitmap.createBitmap(spritesheet,2400,600,300,300);

        zero.setImageBitmap(green);
        zero.setEnabled(false);
        one.setImageBitmap(green2);
        one.setEnabled(false);
        two.setImageBitmap(green3);
        two.setEnabled(false);
        three.setImageBitmap(green4);
        three.setEnabled(false);
        four.setImageBitmap(green5);
        four.setEnabled(false);
        five.setImageBitmap(green6);
        five.setEnabled(false);
        six.setImageBitmap(green7);
        six.setEnabled(false);
        seven.setImageBitmap(green8);
        seven.setEnabled(false);

    }


    public void loadGames(){
        Random randomNumber = new Random();
        int gameChosen = randomNumber.nextInt(5);
        Resources res = getResources();
        int[] bases = new int[9];
        switch (gameChosen){
            case 0:
                bases = res.getIntArray(R.array.game);
                break;
            case 1:
                bases = res.getIntArray(R.array.game_2);
                break;
            case 2:
                bases = res.getIntArray(R.array.game_3);
                break;
            case 3:
                bases = res.getIntArray(R.array.game_4);
                break;
            case 4:
                bases = res.getIntArray(R.array.game_5);
                break;
        }

        int k=0;
        for(int i=0;i<NumSlider.winningNUmbers.length;i++){
            for(int j=0;j<NumSlider.winningNUmbers.length;j++){
                if(bases[k]==0) {
                    NumSlider.gridTiles[i][j].setTileStatus(true);
                   // imagesGroup[k].setVisibility(View.INVISIBLE);

                }
                else {
                    NumSlider.gridTiles[i][j].setTileStatus(false);
                }
                NumSlider.gridTiles[i][j].setTileValue(bases[k]);
                imagesGroup[k].setImageBitmap(sprites[bases[k]]);

                //coordinatesMap.replace(imagesViewGroup[bases[k]].getImage(), k);
                //imagesViewGroup[k].setBitmap(sprites[bases[k]]);
                //imagesViewGroup[k].setValue(k);
                //imagesViewGroup[k].getImage().setImageBitmap(sprites[bases[k]]);



                //imagesViewGroup[k].setValue(bases[k]);
              //  imagesViewGroup[k].setBitmap(sprites[bases[k]]);
               /// imagesViewGroup[k].getImage().setImageBitmap(sprites[bases[k]]);
                k=k+1;
            }
        }




    }

}
