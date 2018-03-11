package aluno;
import java.io.File;
import java.util.Calendar;
import java.util.Iterator;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.Event;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
@SuppressWarnings("unused")
public class Menu extends Application {

	Stage telaMenu;

	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage primaryStage) throws Exception {

		Cadastrar inter = new Cadastrar();
		Imprimir imprimir = new Imprimir();
		telaMenu = primaryStage;
		
		Button cadastrar = new Button("Cadastrar Aluno");
		Button imprime = new Button("Mostrar lista de alunos");
		Button sair = new Button("Sair");
		Button terceiroAluno = new Button("Terceiro aluno e quantidade de alunos cadastrados");
		Button PUmatricula = new Button("Primeira e ultima matricula");
		Button removeAluno = new Button("Remover o último aluno");
		Button maiorMenorIdade = new Button("Maior e menor idade dos alunos");
		Button add3Pos = new Button("Adicionar novo aluno na terceira posição");
		
		Text t = new Text();
		t.setText("JavaFX");
		t.setFont(Font.font("Verdana", 30));
		t.setFill(Color.BLACK);
		
		cadastrar.setOnAction(e -> {
			try {
				inter.start(telaMenu);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		imprime.setOnAction(e -> {
			try {
				imprimir.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		terceiroAluno.setOnAction(e -> {
			aluno3();
		});
		PUmatricula.setOnAction(e -> {
			puMatricula();
		});
		removeAluno.setOnAction(e -> {
			removeUltimoAluno();
		});
		maiorMenorIdade.setOnAction(e -> {
			idadeAluno();
		});
		
		sair.setOnAction(e -> {
			telaMenu.close();
		});
		
		VBox vlayout = new VBox(20);
		vlayout.getChildren().add(t);
		vlayout.getChildren().addAll(cadastrar,imprime,terceiroAluno,PUmatricula,removeAluno,
				maiorMenorIdade,sair);
		vlayout.setPadding(new Insets(10,10,10,10));
		vlayout.setAlignment(Pos.CENTER);

		Scene cena = new Scene(vlayout,400,400);
		
		cena.getStylesheets().add("DarkTheme.css");

		telaMenu.setScene(cena);
		telaMenu.setTitle("M E N U");
		telaMenu.show();
	}
	
	
	private void aluno3() {
		
		Funcoes.leArquivoTxT(Aluno.arrayAluno);
		Aluno mostrarAluno = new Aluno();
		try{
			mostrarAluno = Aluno.arrayAluno.get(2);
			Cadastrar.caixaMensagemSucess("Terceiro aluno: \n\n"+
					"Matricula: "+mostrarAluno.getMatricula()+
					"\nNome: "+mostrarAluno.getNome()+
					"\nData de Nascimento: "+mostrarAluno.getData()+
					"\nIdade: "+mostrarAluno.getIdade()+"\nCPF: "+mostrarAluno.getCPF()+
					"\nTelefone: "+mostrarAluno.getTelefone()+
					"\nNúmero de alunos cadastrados: "+Aluno.arrayAluno.size(), null);
			
		}catch(IndexOutOfBoundsException e){
			Cadastrar.caixaMensagemDeErro("Não existe o terceiro aluno da lista!"+
					"\nNúmero de alunos cadastrados: "+Aluno.arrayAluno.size(), "Erro!");
		}
	}
	
	
	private void puMatricula(){
		try{
		Funcoes.leArquivoTxT(Aluno.arrayAluno);
		Cadastrar.caixaMensagemSucess("Primeira matrícula: "+Aluno.arrayAluno.get(0).getMatricula()+
		"\nÚltima matrícula: "+Aluno.arrayAluno.get(Aluno.arrayAluno.size()-1).getMatricula(), null);
		
		}catch(IndexOutOfBoundsException e){
			Cadastrar.caixaMensagemDeErro("Não existem alunos cadastrados!"+
					"\nNúmero de alunos cadastrados: "+Aluno.arrayAluno.size(), "Erro!");
		}
	}
	
	
	private void removeUltimoAluno(){
		Funcoes.leArquivoTxT(Aluno.arrayAluno);
		try{
			Aluno mostrarAluno = new Aluno();
			mostrarAluno = Aluno.arrayAluno.get(Aluno.arrayAluno.size()-1);
			Cadastrar.caixaMensagemSucess(
					"Remoção do último aluno"+
					"\n\nMatricula: "+mostrarAluno.getMatricula()+
					"\nNome: "+mostrarAluno.getNome()+
					"\nData de Nascimento: "+mostrarAluno.getData()+
					"\nIdade: "+mostrarAluno.getIdade()+
					"\nCPF: "+mostrarAluno.getCPF()+
					"\nTelefone: "+mostrarAluno.getTelefone(), null);
			
			Aluno.arrayAluno.remove(Aluno.arrayAluno.size()-1);
			Funcoes.remove(Aluno.arrayAluno, false);
			
		}catch(IndexOutOfBoundsException e){
			Cadastrar.caixaMensagemDeErro("Não existem alunos cadastrados!"+
					"\nNúmero de alunos cadastrados: "+Aluno.arrayAluno.size(), "Erro!");
		}
	}
	private void idadeAluno(){
		Funcoes.leArquivoTxT(Aluno.arrayAluno);
		int maior = Aluno.arrayAluno.get(0).getIdade();
		int menor = Aluno.arrayAluno.get(0).getIdade();
		Aluno aux;
		for (Iterator<Aluno> iterator = Aluno.arrayAluno.iterator(); iterator.hasNext();) {
			aux = (Aluno) iterator.next();
			if(aux.getIdade() > maior){
				maior = aux.getIdade();
			}
			if(aux.getIdade() < menor){
				menor = aux.getIdade();
			}
		}
		Cadastrar.caixaMensagemSucess("Maior idade dos alunos: "+maior+
									"\nMenor idade dos alunos: "+menor, null);
	}
	private void adicionaNa3Pos(ObservableList<Aluno> arrayAluno) {
		Aluno aux;
		Aluno aux1;
		int i=3;
		for (Iterator<Aluno> iterator = arrayAluno.iterator(); iterator.hasNext();) {
			try{
			aux = (Aluno) iterator.next();
			aux1 = arrayAluno.get(i);
			arrayAluno.set(i, arrayAluno.get(i-1));
			i++;
			}catch(IndexOutOfBoundsException e){
				
			}
		}
	}
}
