package aluno;

import java.util.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Imprimir extends Application {
	
	Stage window;
	Button deleteButton;
	Button Menu;

	ObservableList<Aluno> alunoSelecionado, allAlunos;
	TableView<Aluno> table;

	public static void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Lista de Alunos");
		Funcoes.leArquivoTxT(Aluno.arrayAluno);
		
		//Coluna matricula
		TableColumn<Aluno,String> matriculaColumn = new TableColumn<>("Matricula");
		matriculaColumn.setMinWidth(50);
		matriculaColumn.setCellValueFactory(new PropertyValueFactory<Aluno,String>("matricula"));
		
		//Coluna nome
		TableColumn<Aluno,String> nomeColumn = new TableColumn<>("Nome");
		nomeColumn.setMinWidth(200);
		nomeColumn.setCellValueFactory(new PropertyValueFactory<Aluno,String>("nome"));

		//Coluna idade
		TableColumn<Aluno,Integer> idadeColumn = new TableColumn<>("Idade");
		idadeColumn.setMinWidth(50);
		idadeColumn.setCellValueFactory(new PropertyValueFactory<Aluno,Integer>("idade"));

		//Coluna dataNascimento
		TableColumn<Aluno,Calendar> dataColumn = new TableColumn<>("Data de Nascimento");
		dataColumn.setMinWidth(150);
		dataColumn.setCellValueFactory(new PropertyValueFactory<Aluno,Calendar>("Data"));

		//Coluna cpf
		TableColumn<Aluno,String> cpfColumn = new TableColumn<>("CPF");
		cpfColumn.setMinWidth(100);
		cpfColumn.setCellValueFactory(new PropertyValueFactory<Aluno,String>("CPF"));

		//Coluna telefone
		TableColumn<Aluno,String> telefoneColumn = new TableColumn<>("Telefone");
		telefoneColumn.setMinWidth(100);
		telefoneColumn.setCellValueFactory(new PropertyValueFactory<Aluno,String>("Telefone"));

		table = new TableView<>();
		table.setItems(Aluno.arrayAluno);
		table.getColumns().addAll(matriculaColumn,nomeColumn,idadeColumn,dataColumn, cpfColumn,telefoneColumn);

		Menu telaMenu = new Menu();
		Menu = new Button("Menu");
		Menu.setOnAction(e -> {
			try {
				telaMenu.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		deleteButton = new Button("Delete");
		deleteButton.setOnAction(e -> {
			allAlunos = table.getItems();
			alunoSelecionado = table.getSelectionModel().getSelectedItems();
			alunoSelecionado.forEach(allAlunos::remove);
			Funcoes.remove(Aluno.arrayAluno, false);
			Funcoes.leArquivoTxT(Aluno.arrayAluno);
		});

		HBox hbox = new HBox();
		hbox.setPadding(new Insets(20,20,20,20));
		hbox.setSpacing(10);
		hbox.getChildren().addAll(deleteButton,Menu);
		hbox.setAlignment(Pos.BOTTOM_CENTER);

		VBox vbox = new VBox();
		vbox.getChildren().addAll(table, hbox);


		Scene scene = new Scene(vbox);

		scene.getStylesheets().add("DarkTheme.css");
		window.setScene(scene);
		window.show();
	}
}
