import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GamePanel extends JPanel {

	//Dimension SCREENSIZE = Toolkit.getDefaultToolkit().getScreenSize();
	Dimension SCREENSIZE = new Dimension(1000,1000);
	String boardType;

	
	GamePanel(String config,PlayersPanel players){
		//Game Panel config
		setPreferredSize(new Dimension((int) (SCREENSIZE.width),(int) (SCREENSIZE.height)));
		setLayout(new BorderLayout());
		//

		
		boardType = config;
		//The Game string
		String theGame = "theGame";
		JTextField jtb = new JTextField(theGame);
		add(jtb, BorderLayout.AFTER_LINE_ENDS);
		//

		if(config.equals("simple")) {
			mapLayout = simpleMapPanel();
			String[][] mapGen = buildMap(mapLayout);
			frame =createFrame(mapGen);

		

		}else {
			createComplex();

		}
		

	}


	BufferedImage frame;
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(boardType.equals("simple")) {
			
			if(frame == null) {
				String[][] mapGen = buildMap(mapLayout);
				frame =createFrame(mapGen);
				
			}else {
				g.drawImage(frame, 0, 0, null);
			}
		}
		

	}

	 class MapPiece extends BufferedImage{
		 
	 String pieceType;
		 
		MapPiece(String type){
			super(SCREENSIZE.width/20, SCREENSIZE.height/20, BufferedImage.TYPE_INT_ARGB);
			
			this.pieceType = type;
			generateMapPiece();
	
		}
		
		String getPieceType() {
			return pieceType;
		}
		
		void setPieceType(String ty) {
			
			this.pieceType = ty;
		}
		
		//Paints the piece on to a smaller image that can be added to for players and other on board effects later
		BufferedImage generateMapPiece() { //Rectangles are a temporary fix until we get graphics to replace
			//TODO: Add complex board logic
			Graphics g = getGraphics();
			
			if(pieceType.equals("reg")) {
				
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
				g.drawString("reg",10,30);
			}
			if(pieceType.equals("1l")) {
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
				g.drawString("1l",10,30);
				g.fillRect((SCREENSIZE.height/20-1)-(SCREENSIZE.height/80-1),0,SCREENSIZE.width/80-1,SCREENSIZE.height/20-1);
				g.fillRect(0,0,SCREENSIZE.width/20-1,SCREENSIZE.height/80-1);
				
			}
			if(pieceType.equals("2l")) {
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
				g.drawString("2l",10,30);
				g.fillRect(0,0,SCREENSIZE.width/20-1,SCREENSIZE.height/80-1);
				g.fillRect((SCREENSIZE.height/20-1)-(SCREENSIZE.height/20-1),0,SCREENSIZE.width/80-1,SCREENSIZE.height/20-1);
				
			}
			if(pieceType.equals("3l")) {
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
				g.drawString("3l",10,30);
				g.fillRect(0,(SCREENSIZE.height/20-1)-(SCREENSIZE.height/80-1),SCREENSIZE.width/20-1,SCREENSIZE.height/80-1);
				g.fillRect((SCREENSIZE.height/20-1)-(SCREENSIZE.height/20-1),0,SCREENSIZE.width/80-1,SCREENSIZE.height/20-1);
				
			}
			if(pieceType.equals("4l")) {
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
				g.drawString("4l",10,30);
				g.fillRect((SCREENSIZE.height/20-1)-(SCREENSIZE.height/80-1),0,SCREENSIZE.width/80-1,SCREENSIZE.height/20-1);
				g.fillRect(0,(SCREENSIZE.height/20-1)-(SCREENSIZE.height/80-1),SCREENSIZE.width/20-1,SCREENSIZE.height/80-1);
				
			}
			if(pieceType.equals("1")) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
				g.drawString("1",10,30);
				
			}
			if(pieceType.equals("2")) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
				g.drawString("2",10,30);
				
			}
			if(pieceType.equals("3")) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
				g.drawString("3",10,30);
				
			}
			if(pieceType.equals("4")) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/50)); 
				g.drawString("4",10,30);
				
			}
			if(pieceType.equals("bottomWall")) {
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/100)); 
				g.drawString("bottom",20,30);
				g.fillRect(0,(SCREENSIZE.height/20-1)-(SCREENSIZE.height/80-1),SCREENSIZE.width/20-1,SCREENSIZE.height/80-1);
			}
			if(pieceType.equals("leftWall")) {
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/100)); 
				g.drawString("left",20,30);
				g.fillRect((SCREENSIZE.height/20-1)-(SCREENSIZE.height/20-1),0,SCREENSIZE.width/80-1,SCREENSIZE.height/20-1);
				
			}
			if(pieceType.equals("rightWall")) {
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/100)); 
				g.drawString("right",20,30);
				g.fillRect((SCREENSIZE.height/20-1)-(SCREENSIZE.height/80-1),0,SCREENSIZE.width/80-1,SCREENSIZE.height/20-1);
			}
			if(pieceType.equals("topWall")) {
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0, 0, SCREENSIZE.width/20-1,SCREENSIZE.height/20-1);
				g.setColor(Color.BLACK);
				g.setFont(new Font("TimesRoman", Font.PLAIN, SCREENSIZE.width/100)); 
				g.drawString("top",20,30);
				
				g.fillRect(0,0,SCREENSIZE.width/20-1,SCREENSIZE.height/80-1);
			}
			
			return this;
			
		}
		
	}
	
	
	
	


	BufferedImage createFrame(String[][] stringMapArray){//This will be the 16X16 Map to be displayed to the user
		
		BufferedImage[][] imageMap = new BufferedImage[16][16];

		for(int i = 0; i <16;i++) {
			
			for(int j = 0; j <16;j++) {
				
				imageMap[i][j] = new MapPiece(stringMapArray[i][j]);
			}
		}
		
		BufferedImage toDisplay = new BufferedImage(SCREENSIZE.width/20*16,SCREENSIZE.height/20*16,BufferedImage.TYPE_INT_ARGB);
		
		for(int i = 0; i <16;i++) {
	
			for(int j = 0; j <16;j++) {
				
				for(int k = 0; k < imageMap[i][j].getWidth(); k++) {
					
					for(int l = 0; l < imageMap[i][j].getHeight(); l++) {
						
						toDisplay.setRGB((i*SCREENSIZE.width/20)+k, (j*SCREENSIZE.height/20)+l, imageMap[i][j].getRGB(k, l));
						
					}
				}
				
			}
		}
		//TODO: to add players and goals
		return toDisplay;

	}

	int mapIndex = 0;
	MapPanel[] mapLayout = new MapPanel[4];

	MapPanel[] simpleMapPanel() {// Recursively creates mapLayout randomly using Math.random();

		if(mapIndex == 4) {
			//Turn these on to hard code the map layout to mp1,mp2,mp3,mp4
			//mapLayout[0] = new SimplePanel1(); 
			//mapLayout[1] = new SimplePanel2(); 
			//mapLayout[2] = new SimplePanel3(); 
			//mapLayout[3] = new SimplePanel4(); 
			return mapLayout;

		}else {
			double rnd =Math.random();
			

			//1
			if(0 <= rnd && rnd <= .25) {			
				for(MapPanel mp : mapLayout) {
					if(mp != null && mp.getClass().equals(SimplePanel1.class)) {
						return simpleMapPanel();			
					}
				}
				mapLayout[mapIndex]= new SimplePanel1(); 
				System.out.println(":1");
				mapIndex++;	
			}
			//2
			if(.25 < rnd && rnd <= .5) {
				for(MapPanel mp : mapLayout) {
					if(mp != null && mp.getClass().equals(SimplePanel2.class)) {
						return simpleMapPanel();			
					}
				}
				mapLayout[mapIndex] = new SimplePanel2(); 
				System.out.println(":2");
				mapIndex++;
			}
			//3
			if(.5 < rnd && rnd <= .75) {
				for(MapPanel mp : mapLayout) {
					if(mp != null && mp.getClass().equals(SimplePanel3.class)) {
						return simpleMapPanel();			
					}
				}
				mapLayout[mapIndex] = new SimplePanel3(); 
				System.out.println(":3");
				mapIndex++;
			}
			//4
			if(.75 < rnd && rnd <= 1) {
				for(MapPanel mp : mapLayout) {
					if(mp != null && mp.getClass().equals(SimplePanel4.class)) {
						return simpleMapPanel();

					}
				}
				mapLayout[mapIndex] = new SimplePanel4(); 
				System.out.println(":4");
				mapIndex++;
			}
			
			return simpleMapPanel();
		}
	}

	void createComplex() {//copy createSimple and continue

	}
	//Takes a map layout and create a 16x16 GameMap of type String[][]
	String[][] buildMap(MapPanel[] mapLayout ){

		String[][] map = new String[16][16];

		MapPanel mp1 = rotate2DStringArray(mapLayout[0],2);
		MapPanel mp2 = rotate2DStringArray(mapLayout[1],1);
		MapPanel mp3 = rotate2DStringArray(mapLayout[2],4);
		MapPanel mp4 = rotate2DStringArray(mapLayout[3],3);
		
		System.out.println("Should be 4 zeros");
		System.out.println("mp1: " + mp1.getMap()[7][7]);
		System.out.println("mp2: " + mp2.getMap()[0][7]);
		System.out.println("mp3: " + mp3.getMap()[0][0]);
		System.out.println("mp4: " + mp4.getMap()[7][0]);


		for(int i = 0; i< 8; i++) {

			for(int j = 0; j< 8; j++) {

				map[i][j] = mp1.getMap()[i][j];

			}
		}
		for(int i = 0; i< 8; i++) {

			for(int j = 0; j< 8; j++) {

				map[i+8][j] = mp2.getMap()[i][j];

			}
		}
		for(int i = 0; i< 8; i++) {

			for(int j = 0; j< 8; j++) {

				map[i+8][j+8] = mp3.getMap()[i][j];

			}
		}
		for(int i = 0; i< 8; i++) {

			for(int j = 0; j< 8; j++) {

				map[i][j+8] = mp4.getMap()[i][j];

			}
		}

		return map;

	}
	//Recursive function to rotate a MapPanel to a specified outputQuadrant 
	MapPanel rotate2DStringArray(MapPanel toRotate,int outputQuadrant) {

		System.out.println("outputQuadrant: "+outputQuadrant +"  toRotate: " +toRotate.getPanelLocation());
		if(outputQuadrant == toRotate.getPanelLocation()) {
			return toRotate;
		}else {

			int size = 7;
			String[][] toReturn = new String[8][8];

			for(int i = 0 ;i<=size ;i++) {

				toReturn[i][0] = toRotate.getMap()[0][size-i];
				toReturn[i][1] = toRotate.getMap()[1][size-i];
				toReturn[i][2] = toRotate.getMap()[2][size-i];
				toReturn[i][3] = toRotate.getMap()[3][size-i];
				toReturn[i][4] = toRotate.getMap()[4][size-i];
				toReturn[i][5] = toRotate.getMap()[5][size-i];
				toReturn[i][6] = toRotate.getMap()[6][size-i];
				toReturn[i][7] = toRotate.getMap()[7][size-i];

			}
			int indexI=0;
			int indexJ=0;
			//We need to rotate the MapPieces as well
			for(String[] toRetur: toReturn) {
				indexI=0;
				for(String toRetu: toRetur) {
					
					//TODO: Add complex board logic (Diagonal)
					if(toRetu.equals("topWall")) {
						toReturn[indexJ][indexI] ="rightWall";
					}
					if(toRetu.equals("rightWall")) {
						toReturn[indexJ][indexI] ="bottomWall";
					}
					if(toRetu.equals("bottomWall")) {
						toReturn[indexJ][indexI] ="leftWall";
					}
					if(toRetu.equals("leftWall")) {
						toReturn[indexJ][indexI] ="topWall";
					}
					if(toRetu.equals("1l")) {
						toReturn[indexJ][indexI] ="4l";
					}
					if(toRetu.equals("4l")) {
						toReturn[indexJ][indexI] ="3l";
					}
					if(toRetu.equals("3l")) {
						toReturn[indexJ][indexI] ="2l";
					}
					if(toRetu.equals("2l")) {
						toReturn[indexJ][indexI] ="1l";
					}
					indexI++;
				}
				indexJ++;
			}

			toRotate.setMap(toReturn);
			//Need to add logic to rotate l1,l2,l3,l4 and walls
			toRotate.setPanelLocation(toRotate.getPanelLocation()-1);

			if(toRotate.getPanelLocation() <1) {

				toRotate.setPanelLocation(4);
			}

			return rotate2DStringArray(toRotate,outputQuadrant);

		}


	}



	abstract class MapPanel{ //Wrapper class for SimplePanel1,SimplePanel2,...


		String[][] map =  {{"reg","reg","reg","reg","reg","reg","reg","reg"},
				{"reg","reg","reg","reg","reg","reg","reg","reg"},
				{"reg","reg","reg","reg","reg","reg","reg","reg"},
				{"reg","reg","reg","reg","reg","reg","reg","reg",},
				{"reg","reg","reg","reg","reg","reg","reg","reg",},
				{"reg","reg","reg","reg","reg","reg","reg","reg",},
				{"reg","reg","reg","reg","reg","reg","reg","reg",},
				{"reg","reg","reg","reg","reg","reg","reg","reg",}};

		MapPanel(){

		}	

		abstract String[][] getMap();

		abstract void setMap(String[][] newMap);

		abstract void setPanelLocation(int a);


		abstract int getPanelNum();

		abstract int getPanelLocation();


	}

	class SimplePanel1 extends MapPanel{


		public int panelNum = 1;
		public int panelLocation = 2;//in Quadrants

		SimplePanel1(){
			super();

		}

		int SIZE = 8;

		//This an 8x8 Array used to store the board.
		//To access a piece, call map[i][j] where i in the positive x direction
		//and j is in the negative y value. In other words, map in in quadrant 4 by default
		String[][] mapold = {{"reg"},{"reg"},{"leftWall"},{"reg"},{"reg"},{"reg"},{"reg"},{"reg"},
							{"reg"},{"reg"},{"reg"},{"reg"},{"2l"},{"reg"},{"reg"},{"reg"},
							{"reg"},{"1l"},{"reg"},{"reg"},{"reg"},{"reg"},{"reg"},{"reg"},
							{"reg"},{"reg"},{"reg"},{"reg"},{"reg"},{"reg"},{"4l"},{"reg"},
							{"reg"},{"reg"},{"reg"},{"reg"},{"reg"},{"reg"},{"reg"},{"reg"},
							{"bottomWall"},{"reg"},{"reg"},{"reg"},{"reg"},{"reg"},{"reg"},{"reg"},
							{"reg"},{"reg"},{"reg"},{"3l"},{"reg"},{"reg"},{"reg"},{"reg"},
							{"reg"},{"reg"},{"reg"},{"reg"},{"reg"},{"reg"},{"reg"},{"0"}};

		String[][] map = {{"reg","reg","reg","reg","reg","bottomWall","reg","reg"},
				{"reg","reg","1l","reg","reg","reg","reg","reg"},
				{"leftWall","reg","reg","reg","reg","reg","reg","reg"},
				{"reg","reg","reg","reg","reg","reg","3l","reg",},
				{"reg","2l","reg","reg","reg","reg","reg","reg",},
				{"reg","reg","reg","reg","reg","reg","reg","reg",},
				{"reg","reg","reg","4l","reg","reg","reg","reg",},
				{"reg","reg","reg","reg","reg","reg","reg","1",}};//add numbers from 1-4 instead of 0's

		@Override
		String[][] getMap(){
			return map;

		}
		@Override
		int getPanelNum() {
			return panelNum;

		}

		@Override
		void setMap(String[][] newMap) {
			map = newMap;

		}
		@Override
		int getPanelLocation() {
			return panelLocation;
		}
		@Override
		void setPanelLocation(int a) {

			panelLocation = a;
		}

	}

	class SimplePanel2 extends MapPanel{

		int panelNum = 2;
		public int panelLocation = 2;//in Quadrants

		SimplePanel2(){
			super();
		}
		//This an 8x8 Array used to store the board.
		//To access a piece, call map[i][j] where i in the positive x direction
		//and j is in the negative y value. In other words, map in in quadrant 4 by default
	
		String[][] map = {{"reg","reg","reg","bottomWall","reg","reg","reg","reg"},
				{"reg","reg","3l","reg","reg","reg","reg","reg"},
				{"reg","reg","reg","reg","reg","reg","1l","reg"},
				{"leftWall","reg","reg","reg","reg","reg","reg","reg",},
				{"reg","reg","reg","reg","reg","reg","reg","reg",},
				{"reg","4l","reg","reg","reg","reg","reg","reg",},
				{"reg","reg","reg","reg","2l","reg","reg","reg",},
				{"reg","reg","reg","reg","reg","reg","reg","2",}};

		@Override
		String[][] getMap(){
			return map;

		}
		@Override
		int getPanelNum() {
			return panelNum;

		}

		@Override
		void setMap(String[][] newMap) {
			map = newMap;

		}
		@Override
		int getPanelLocation() {

			return panelLocation;
		}
		@Override
		void setPanelLocation(int a) {

			panelLocation = a;		
		}

	}

	class SimplePanel3 extends MapPanel{

		int panelNum = 3;
		public int panelLocation = 2;//in Quadrants

		SimplePanel3(){
			super();
		}

		//This an 8x8 Array used to store the board.
		//To access a piece, call map[i][j] where i in the positive x direction
		//and j is in the negative y value. In other words, map in in quadrant 4 by default

		String[][] map = {{"reg","reg","reg","reg","bottomWall","reg","reg","reg"},
				{"reg","reg","reg","reg","reg","reg","2l","reg"},
				{"reg","reg","reg","reg","1l","reg","reg","reg"},
				{"reg","reg","reg","reg","reg","reg","reg","reg",},
				{"leftWall","reg","reg","reg","reg","reg","reg","reg",},
				{"reg","reg","4l","reg","reg","reg","reg","reg",},
				{"reg","reg","reg","reg","reg","reg","reg","reg",},
				{"reg","reg","reg","reg","reg","3l","reg","3",}};
		@Override
		String[][] getMap(){
			return map;

		}
		@Override
		int getPanelNum() {
			return panelNum;

		}

		@Override
		void setMap(String[][] newMap) {
			map = newMap;

		}
		@Override
		int getPanelLocation() {

			return panelLocation;
		}

		@Override
		void setPanelLocation(int a) {

			panelLocation = a;
		}
	}

	class SimplePanel4 extends MapPanel{

		int panelNum = 4;
		public int panelLocation = 2;//in Quadrants

		SimplePanel4(){
			super();
		}

		//This an 8x8 Array used to store the board.
		//To access a piece, call map[i][j] where i in the positive x direction
		//and j is in the negative y value. In other words, map in in quadrant 4 by default
		

		String[][] map = {{"reg","reg","reg","reg","reg","reg","bottomWall","reg"},
						{"reg","reg","reg","1l","reg","reg","reg","reg"},
						{"reg","reg","reg","reg","reg","4l","reg","reg"},
						{"reg","reg","reg","reg","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","2l","reg","reg","reg",},
						{"reg","3l","reg","reg","reg","reg","reg","reg",},
						{"reg","reg","reg","reg","reg","4l","reg","4",}};
		@Override
		String[][] getMap(){
			return map;

		}
		@Override
		int getPanelNum() {
			return panelNum;

		}

		@Override
		void setMap(String[][] newMap) {
			map = newMap;

		}
		@Override
		int getPanelLocation() {

			return panelLocation;
		}

		@Override
		void setPanelLocation(int a) {

			panelLocation = a;
		}
	}
	//TODO: Add complex board logic
	class complexPanel1{

	}
	//TODO: Add complex board logic
	class complexPanel2{

	}
	//TODO: Add complex board logic
	class complexPanel3{

	}
	//TODO: Add complex board logic
	class complexPanel4{

	}

	
}