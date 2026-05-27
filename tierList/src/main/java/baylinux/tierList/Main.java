package baylinux.tierList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application 
{
	
	static int sceneWidth=1600;
	static int sceneHeight=900;
	static int rowNumber=7;
	static double leftPartWidthPercentage=0.7;
	static double rightPartWidthPercentage=1-leftPartWidthPercentage;
	static double imageHeightPercentage=0.65;
	static double textFieldHeightPercentage=1-imageHeightPercentage;
	static StackPane imf;
	static ImageView iv;
	static Image img;
	static Button closeBtn;
	static TextField tf;
	@Override
	public void start(Stage primaryStage) throws InterruptedException 
	{
		try 
		{
			
			
//			Group root = new Group();
			SplitPane root = new SplitPane();
			VBox leftPart = new VBox();
			VBox rightPart= new VBox();

			
			root.getItems().addAll(leftPart, rightPart);
			
			root.setDividerPositions(leftPartWidthPercentage);
			
			
			Scene scene=new Scene(root,sceneWidth,sceneHeight);
			
			
			
			List<HBox> tiers=new ArrayList<HBox>();
			
			int i=0;
			while(i<7)
			{
				tiers.add(new HBox());
				tiers.get(i).setStyle("-fx-border-color: black; -fx-border-width: 1;");
				tiers.get(i).setPrefWidth(sceneWidth*leftPartWidthPercentage);
				tiers.get(i).setPrefHeight(sceneHeight/7);
				leftPart.getChildren().add(tiers.get(i));
				i+=1;
			}
			List<HBox> rows=new ArrayList<HBox>();
			
			int h=0;
			while(h<7)
			{
				rows.add(new HBox());
				//rows.get(h).setStyle("-fx-border-color: black; -fx-border-width: 1;");
				rows.get(h).setPrefWidth(sceneWidth*leftPartWidthPercentage);
				rows.get(h).setPrefHeight(sceneHeight/7);
				rightPart.getChildren().add(rows.get(h));
				h+=1;
			}
			
			

			
			String[] ranks = {"S", "A", "B", "C", "D", "E","F"};
			
			List<Label> labels=new ArrayList<Label>();
			int k = 0;
			while(k < tiers.size())
			{
			    Label label = new Label(ranks[k]);
			    labels.add(label);
			    labels.get(k).setPrefWidth((sceneWidth*leftPartWidthPercentage)/10);
			    labels.get(k).setPrefHeight(sceneHeight/7);
			    labels.get(k).setAlignment(Pos.CENTER);
			    if(k==0) labels.get(k).setStyle("-fx-background-color: yellow;-fx-font-size: 5em; -fx-font-weight: bold; -fx-text-align:right;");
			    if(k==1) labels.get(k).setStyle("-fx-background-color: green;-fx-font-size: 5em; -fx-font-weight: bold; -fx-text-align:right;");
			    if(k==2) labels.get(k).setStyle("-fx-background-color: #6F4E37;-fx-font-size: 5em; -fx-font-weight: bold; -fx-text-align:right;");
			    if(k==3) labels.get(k).setStyle("-fx-background-color: lightgray;-fx-font-size: 5em; -fx-font-weight: bold; -fx-text-align:right;");
			    if(k==4) labels.get(k).setStyle("-fx-background-color: white;-fx-font-size: 5em; -fx-font-weight: bold; -fx-text-align:right;");
			    if(k==5) labels.get(k).setStyle("-fx-background-color: red;-fx-font-size: 5em; -fx-font-weight: bold; -fx-text-align:right;");
			    if(k==6) labels.get(k).setStyle("-fx-background-color: purple;-fx-font-size: 5em; -fx-font-weight: bold; -fx-text-align:right;");
			    tiers.get(k).getChildren().add(labels.get(k));
			    k++;
			}
			
			
			
			rightPart.setOnDragOver(event ->
			{	
				if(event.getGestureSource() != rightPart && event.getDragboard().hasFiles())
				{
					event.acceptTransferModes(javafx.scene.input.TransferMode.COPY);
				}
				event.consume();
				
			});
			
			rightPart.setOnDragDropped(e -> 
			{

			    Dragboard db = e.getDragboard();

			    if (db.hasFiles()) 
			    {

			        for (File file : db.getFiles()) 
			        {

			            img = new Image(file.toURI().toString());
			            closeBtn = new Button("X");
			    		closeBtn.setStyle(
			    		    "-fx-background-color: transparent;" +
			    		    "-fx-text-fill: red;" +
			    		    "-fx-font-weight: bold;"+
			    		    "-fx-padding: 0;"+
			    		    "-fx-font-size:20px;"
			    		  
			    		);
			    		
			    		closeBtn.setOnMouseEntered(ef ->
			    		{
			    			closeBtn.setStyle("-fx-background-color: red; -fx-text-fill: black;-fx-font-weight: bold; -fx-padding:0; -fx-font-size:20px;");
			    		});

				    	closeBtn.setOnMouseExited(eg ->
				    	{
				    	    closeBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: red; -fx-font-weight: bold; -fx-padding:0; -fx-font-size:20px;");
				    	});
			    		
			    		
			    		imf = new StackPane();
			    		
			    		iv = new ImageView(img);
			    		iv.setFitHeight((sceneHeight/rowNumber)*imageHeightPercentage);
			    		iv.setFitWidth((sceneWidth*rightPartWidthPercentage)/3);
			    		iv.fitWidthProperty().bind(imf.widthProperty());
			    		iv.setPreserveRatio(true);
			    		iv.setPreserveRatio(true);
			    		imf.getChildren().addAll(closeBtn,iv);
			    		imf.setPadding(Insets.EMPTY);
			    		StackPane.setAlignment(closeBtn, Pos.TOP_RIGHT);
			    		StackPane.setMargin(closeBtn, new Insets(0, 0, 0, 0));
			    		closeBtn.toFront();

			    	    tf = new TextField();
			    	    tf.setPrefHeight((sceneHeight/rowNumber)*textFieldHeightPercentage);
			    		tf.setPrefWidth((sceneWidth*rightPartWidthPercentage)/3);
			    	    tf.setStyle("-fx-font-size:16px;-fx-font-weight: bold; -fx-alignment:center;");

			    	    VBox card = new VBox(imf, tf);
			    	    card.setPrefHeight(sceneHeight/rowNumber);
			    	    card.setPrefWidth((sceneWidth*rightPartWidthPercentage)/3);
			    	    card.setStyle("-fx-border-color: black;");
			    	   
			    	    closeBtn.setOnAction(eh -> 
			    	    {

			    		    Parent parent = card.getParent();
			    		    
			    		    boolean rightRowsContains=false;
			    		    
			    		    for (HBox row : rows) 
			    		    {
			    		        if (row == parent) rightRowsContains=true;
			    		    }
			    		    
			    		    
			    		    if (rightRowsContains==true) 
			    		    {

			    		        ((Pane) parent).getChildren().remove(card);

			    		    }
			    		    else {

			    		        ((Pane) parent).getChildren().remove(card);

			    		        for (HBox row : rows) 
			    			    {
			    			        if (row.getChildren().size() < 3) 
			    			        {
			    			            row.getChildren().add(card);
			    			            return;
			    			        }
			    			    }
			    		    }
			    		});
			    	    
			    	    card.setOnDragDetected(ex -> 
			    	    {

			    	        Dragboard db2 = card.startDragAndDrop(TransferMode.MOVE);

			    	        ClipboardContent content = new ClipboardContent();
			    	        content.putString("CARD");

			    	        db2.setContent(content);

			    	        ex.consume();
			    	    });

			            for (HBox row : rows) 
			    	    {
			    	        if (row.getChildren().size() < 3) 
			    	        {
			    	            row.getChildren().add(card);
			    	            return;
			    	        }
			    	    }
			        }
			    }

			    e.setDropCompleted(true);
			    e.consume();
			});
			
			for (HBox tier : tiers) 
			{

			    tier.setOnDragOver(e -> 
			    {
			        if (e.getDragboard().hasString()) 
			        {
			            e.acceptTransferModes(TransferMode.MOVE);
			        }
			        e.consume();
			    });

			    tier.setOnDragDropped(e -> 
			    {

			        Node card = (Node) e.getGestureSource();

			        ((Pane) card.getParent()).getChildren().remove(card);
			        tier.getChildren().add(card);

			        e.setDropCompleted(true);
			        e.consume();
			    });
			}
			
			scene.widthProperty().addListener((obs, oldVal, newVal) -> 
			{
				int newSceneWidth=newVal.intValue();
				root.setDividerPositions(leftPartWidthPercentage);
				
			});
			
			scene.heightProperty().addListener((obs, oldVal, newVal) -> 
			{
				int newSceneHeight=newVal.intValue();
				int j=0;
				while(j<tiers.size())
				{
					tiers.get(j).setPrefHeight(newSceneHeight/rowNumber);
					j+=1;
				}
				int d=0;
				while(d<rows.size())
				{
					rows.get(d).setPrefHeight(newSceneHeight/rowNumber);
					d+=1;
				}
				int f=0;
				while(f<labels.size())
				{
					labels.get(f).setPrefHeight(newSceneHeight/rowNumber);
					f+=1;
				}
				iv.setFitHeight((newSceneHeight/rowNumber)*imageHeightPercentage);
	    		tf.setPrefHeight((newSceneHeight/rowNumber)*textFieldHeightPercentage);
	    		
			});
			
			
//			Scene scene = new Scene(root,1200,700);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
//			primaryStage.getIcons().add(
//					new Image(Main.class
//					.getResourceAsStream(logo)));
			primaryStage.show();
			
			
			
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		launch(args);
		
	}

	
}
