package fr.univ_amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Exercice 4 - Mise en page d'un formulaire.
 *
 * <p>Objectif : reproduire la maquette d'un mini-formulaire en combinant plusieurs conteneurs
 * JavaFX. L'exercice force à réfléchir à la décomposition d'une IHM en zones.
 *
 * <h3>Maquette à reproduire</h3>
 *
 * <pre>
 * ┌───────────────────────────────┐
 * │ [Fichier] [Aide]              │  ← MenuBar
 * ├───────────────────────────────┤
 * │ Nom :     [__________]        │  ┐
 * │ Email :   [__________]        │  │ GridPane (2 × 2)
 * │                               │  ┘
 * │ [  Valider  ]  [ Annuler ]    │  ← HBox
 * └───────────────────────────────┘
 * </pre>
 *
 * Concepts : {@link javafx.scene.layout.BorderPane}, {@link javafx.scene.layout.GridPane}, {@link
 * javafx.scene.layout.HBox}, {@link javafx.scene.control.MenuBar}.
 */
public class MiseEnPage extends Application {

  @Override
  public void start(Stage primaryStage) {
    BorderPane root = new BorderPane();

    MenuBar menuBar = new MenuBar();
    Menu menuFichier = new Menu("Fichier");
    Menu menuAide = new Menu("Aide");
    menuBar.getMenus().addAll(menuFichier, menuAide);
    root.setTop(menuBar);

    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(20));

    grid.add(new Label("Nom :"), 0, 0);
    grid.add(new TextField(), 1, 0);
    grid.add(new Label("Email :"), 0, 1);
    grid.add(new TextField(), 1, 1);

    root.setCenter(grid);

    HBox bottomBox = new HBox(10);
    bottomBox.setPadding(new Insets(15));
    bottomBox.setAlignment(Pos.CENTER_RIGHT);

    Button btnValider = new Button("Valider");
    Button btnAnnuler = new Button("Annuler");

    bottomBox.getChildren().addAll(btnValider, btnAnnuler);
    root.setBottom(bottomBox);

    Scene scene = new Scene(root, 400, 250);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
