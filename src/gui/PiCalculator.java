package gui;

import ArcTan_approxiamtions.Equations;
import RamJan.Ramanujan;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.math.BigDecimal;

/**
 * Created by Erez on 12/12/2016.
 */
public class PiCalculator extends Application
{
    private Stage calculator;
    private BorderPane calcLayout;

    private HBox entryFields;
    private Label topMess;
    private TextField n_entry;
    private TextField x_entry;

    private HBox v_Boxes;

    private VBox equations;
    private Label eqtn_A;
    private Label eqtn_B;
    private Label eqtn_C;
    private Label eqtn_D;
    private Label arcTanApprox;
    private Label ramJan;

    /**
    private VBox times;
    private Label time_A;
    private Label time_B;
    private Label time_C;
    private Label time_D;
    private Label time_Approx;
    private Label time_RamJan;
     */

    private HBox bottomButtons;
    private Button go;
    private Button credits;

    private Stage creditStage;
    private FlowPane creditLayout;
    private Label creditScreen;
    private Button closeCreds;

    public PiCalculator()
    {
        creditStage = new Stage();
        creditLayout = new FlowPane();
        creditScreen = new Label();
        closeCreds = new Button("Done");
        creditStage.setTitle("Credits");
        //TODO make actual screen here this URL is nothing RN
        creditScreen.setGraphic(new ImageView("File:src/Images/credits.png"));
        closeCreds.setOnAction(close -> creditStage.close());
        creditLayout.getChildren().add(creditScreen);
        creditStage.setScene(new Scene(creditLayout));
    }

    public void init(){}

    public static void maint(String[] args){Application.launch();}

    public void start(Stage stage) throws Exception
    {
        this.calculator = stage;
        calculator.setTitle("The great and mighty π calculator!");
        this.calcLayout = new BorderPane();
        calcLayout.setPadding(new Insets(50,50,50,50));

        this.entryFields = new HBox();
        entryFields.setPadding(new Insets(50,50,50,50));
        entryFields.setSpacing(200);
        this.topMess = new Label("Input an x value and an n value");
        this.n_entry = new TextField();
        n_entry.setPromptText("n value");
        this.x_entry = new TextField();
        x_entry.setPromptText("x value");
        entryFields.getChildren().addAll(x_entry, topMess,n_entry);

        equations = new VBox();
        equations.setPadding(new Insets(50,50,50,50));
        eqtn_A = new Label();
        eqtn_B = new Label();
        eqtn_C = new Label();
        eqtn_D = new Label();
        arcTanApprox = new Label();
        ramJan = new Label();

        ImageView imageA = new ImageView("File:src/Images/eqtnA.png");
        imageA.setFitHeight(75);
        imageA.setFitWidth(500);
        eqtn_A.setGraphic(imageA);

        ImageView imageB = new ImageView("File:src/Images/eqtnB.png");
        imageB.setFitHeight(75);
        imageB.setFitWidth(500);
        eqtn_B.setGraphic(imageB);

        ImageView imageC = new ImageView("File:src/Images/eqtnC.png");
        imageC.setFitHeight(75);
        imageC.setFitWidth(500);
        eqtn_C.setGraphic(imageC);

        ImageView imageD = new ImageView("File:src/Images/eqtnD.png");
        imageD.setFitHeight(75);
        imageD.setFitWidth(500);
        eqtn_D.setGraphic(imageD);

        ImageView arcTanImage = new ImageView("File:src/Images/arcTan.png");
        arcTanImage.setFitHeight(75);
        arcTanImage.setFitWidth(500);
        arcTanApprox.setGraphic(arcTanImage);

        ImageView ramJanimage = new ImageView("File:src/Images/ramJan.png");
        ramJanimage.setFitHeight(75);
        ramJanimage.setFitWidth(500);
        ramJan.setGraphic(ramJanimage);


        equations.getChildren().addAll(eqtn_A, eqtn_B, eqtn_C, eqtn_D, arcTanApprox, ramJan);

        /**
        times = new VBox();
        times.setPadding(new Insets(50,50,50,50));
        time_A = new Label("0");
        time_B = new Label("0");
        time_C = new Label("0");
        time_D = new Label("0");
        time_Approx = new Label("0");
        time_RamJan = new Label("0");
        times.getChildren().addAll(time_A, time_B, time_C, time_D, time_Approx, time_RamJan);
         */

        v_Boxes = new HBox();
        v_Boxes.setPadding(new Insets(50,50,50,50));
        v_Boxes.getChildren().addAll(equations); //times);

        bottomButtons = new HBox();
        bottomButtons.setPadding(new Insets(50,50,50,50));
        go = new Button("Solve");
        go.setOnAction(solve ->
        {
            String n_String = this.n_entry.getText();
            String x_String = this.x_entry.getText();
            int n_int = Integer.parseInt(n_String);
            BigDecimal x_bigD = BigDecimal.valueOf(Double.parseDouble(x_String));
            Equations eqs = new Equations(x_bigD, n_int);
            Ramanujan ramJaman = new Ramanujan(n_int);
            eqs.main(null);
            ramJaman.main(null);

            eqtn_A.setText(""+eqs.getPi_1());
            eqtn_B.setText(""+eqs.getPi_2());
            eqtn_C.setText(""+eqs.getPi_3());
            eqtn_D.setText(""+eqs.getPi_4());
            arcTanApprox.setText(""+eqs.getArcTan());
            ramJan.setText(""+ramJaman.getPi());
        });
        credits = new Button("Credits");
        credits.setOnAction(openCreds -> this.creditStage.show());
        bottomButtons.getChildren().addAll(go, credits);
        bottomButtons.setSpacing(200);

        calcLayout.setTop(entryFields);
        calcLayout.setCenter(v_Boxes);
        calcLayout.setBottom(bottomButtons);
        calculator.setScene(new Scene(calcLayout));
        calculator.show();
    }


}
