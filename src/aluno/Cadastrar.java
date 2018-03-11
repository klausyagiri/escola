package aluno;

import java.util.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


@SuppressWarnings("unused")
public class Cadastrar extends Application{

	TextField nomeFX;
	TextField cpfFX;
	TextField telefoneFX;
	
	String dia,mes,ano;

	Button botaoCadastrar;
	Button limpar;
	Button voltar;

	Label labelnome,labelcpf,labeltelefone,labeldata;

	Stage telaCadastro;

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception{


		telaCadastro = primaryStage;
		Text t = new Text();
		t.setText("Cadastro");
		t.setFont(Font.font("Verdana", 20));
		t.setFill(Color.BLACK);

		this.nomeFX = new TextField();
		this.nomeFX.setPromptText("NOME");
		this.nomeFX.setMinWidth(150);
		this.nomeFX.setMaxWidth(300);

		ChoiceBox<String> choiceDia = new ChoiceBox<>();
		choiceDia.getItems().add("Dia");
		choiceDia.getItems().add("1");
		choiceDia.getItems().add("2");
		choiceDia.getItems().add("3");
		choiceDia.getItems().add("4");
		choiceDia.getItems().add("5");
		choiceDia.getItems().add("6");
		choiceDia.getItems().add("7");
		choiceDia.getItems().add("8");
		choiceDia.getItems().add("9");
		choiceDia.getItems().add("10");
		choiceDia.getItems().add("11");
		choiceDia.getItems().add("12");
		choiceDia.getItems().add("13");
		choiceDia.getItems().add("14");
		choiceDia.getItems().add("15");
		choiceDia.getItems().add("16");
		choiceDia.getItems().add("17");
		choiceDia.getItems().add("18");
		choiceDia.getItems().add("19");
		choiceDia.getItems().add("20");
		choiceDia.getItems().add("21");
		choiceDia.getItems().add("22");
		choiceDia.getItems().add("23");
		choiceDia.getItems().add("24");
		choiceDia.getItems().add("25");
		choiceDia.getItems().add("26");
		choiceDia.getItems().add("27");
		choiceDia.getItems().add("28");
		choiceDia.getItems().add("29");
		choiceDia.getItems().add("30");
		choiceDia.getItems().add("31");
		choiceDia.setValue("Dia");


		ChoiceBox<String> choiceMes = new ChoiceBox<>();
		choiceMes.getItems().add("Mês");
		choiceMes.getItems().add("01");
		choiceMes.getItems().add("02");
		choiceMes.getItems().add("03");
		choiceMes.getItems().add("04");
		choiceMes.getItems().add("05");
		choiceMes.getItems().add("06");
		choiceMes.getItems().add("07");
		choiceMes.getItems().add("08");
		choiceMes.getItems().add("09");
		choiceMes.getItems().add("10");
		choiceMes.getItems().add("11");
		choiceMes.getItems().add("12");
		choiceMes.setValue("Mês");

		ChoiceBox<String> choiceAno = new ChoiceBox<>();
		choiceAno.getItems().add("Ano");
		choiceAno.getItems().add("1980");
		choiceAno.getItems().add("1981");
		choiceAno.getItems().add("1982");
		choiceAno.getItems().add("1983");
		choiceAno.getItems().add("1984");
		choiceAno.getItems().add("1985");
		choiceAno.getItems().add("1986");
		choiceAno.getItems().add("1987");
		choiceAno.getItems().add("1988");
		choiceAno.getItems().add("1989");
		choiceAno.getItems().add("1990");
		choiceAno.getItems().add("1991");
		choiceAno.getItems().add("1992");
		choiceAno.getItems().add("1993");
		choiceAno.getItems().add("1994");
		choiceAno.getItems().add("1995");
		choiceAno.getItems().add("1996");
		choiceAno.getItems().add("1997");
		choiceAno.getItems().add("1998");
		choiceAno.getItems().add("1999");
		choiceAno.getItems().add("2000");
		choiceAno.getItems().add("2001");
		choiceAno.getItems().add("2002");
		choiceAno.getItems().add("2003");
		choiceAno.getItems().add("2004");
		choiceAno.getItems().add("2005");
		choiceAno.getItems().add("2006");
		choiceAno.getItems().add("2007");
		choiceAno.getItems().add("2008");
		choiceAno.getItems().add("2009");
		choiceAno.getItems().add("2010");
		choiceAno.getItems().add("2011");
		choiceAno.getItems().add("2012");
		choiceAno.getItems().add("2013");
		choiceAno.getItems().add("2014");
		choiceAno.getItems().add("2015");
		choiceAno.getItems().add("2016");
		choiceAno.getItems().add("2017");
		choiceAno.getItems().add("2018");
		choiceAno.setValue("Ano");

		this.cpfFX = new TextField();
		this.cpfFX.setPromptText("CPF");
		this.cpfFX.setMaxWidth(150);

		this.telefoneFX = new TextField();
		this.telefoneFX.setPromptText("Telefone");
		this.telefoneFX.setMaxWidth(150);

		this.botaoCadastrar = new Button("Cadastrar");
		botaoCadastrar.setOnAction(e-> {

			//VERIFICA OS ERROS, SE TEM LETRA NOS CAMPOS INTEIROS
			boolean cadastra=true;
			String dia,mes,ano;
			int auxdia=0,auxmes=0,auxano=0;
			String telefone;
			long auxtelefoneFX;
			String cpf;
			long auxcpf;
			dia = getChoice(choiceDia);

			mes = getChoice(choiceMes);

			ano = getChoice(choiceAno);

			try{
				
				telefone = this.telefoneFX.getText();
				auxtelefoneFX = Long.parseLong(telefone);

				cpf = this.cpfFX.getText();
				auxcpf = Long.parseLong(cpf);
				
			}catch(NumberFormatException e1){
				
				cadastra = false;
				caixaMensagemDeErro("Digite apenas números !", "Information!");
				
			}finally{
				
				String nome = nomeFX.getText();
				
				dia = getChoice(choiceDia);
				mes = getChoice(choiceMes);
				ano = getChoice(choiceAno);

				telefone = this.telefoneFX.getText();
				cpf = this.cpfFX.getText();
				auxcpf = Long.parseLong(cpf);

				cadastra = validaCampos(dia,mes,ano,telefone, cpf, nome) ; 
				if (cadastra == true){
					nome = Funcoes.formataNome(nome);
					auxdia = Integer.parseInt(dia);
					auxmes = Integer.parseInt(mes) - 1;
					auxano = Integer.parseInt(ano);
					Funcoes.leArquivoTxT(Aluno.arrayAluno);
					adicionaNovoAluno(Aluno.arrayAluno, nome, auxdia,auxmes,auxano, cpf, telefone);
					this.nomeFX.clear();
					System.out.println("Dps de cadastrar:"+Aluno.numMatricula);
					choiceDia.setValue("Dia");
					choiceMes.setValue("Mês");
					choiceAno.setValue("Ano");
					this.cpfFX.clear();
					this.telefoneFX.clear();
					Funcoes.escreveNoArquivo(Aluno.arrayAluno,true, nome, auxdia,auxmes,auxano,
							cpf, telefone);
					Funcoes.leArquivoTxT(Aluno.arrayAluno);
					Aluno mostrarAluno;
					mostrarAluno = Aluno.arrayAluno.get(Aluno.arrayAluno.size()-1);
					System.out.println(Aluno.arrayAluno.size());
					caixaMensagemSucess(
							
							"\n\nMatricula: "+mostrarAluno.getMatricula()+
							"\nNome: "+mostrarAluno.getNome()+
							"\nData de Nascimento: "+mostrarAluno.getData()+
							"\nIdade: "+mostrarAluno.getIdade()+
							"\nCPF: "+mostrarAluno.getCPF()+
							"\nTelefone: "+mostrarAluno.getTelefone()+
							"\nCadastrado!", null);
				}
			}
		});
		this.limpar = new Button("Limpar Campos");
		limpar.setOnAction(e-> {
			this.nomeFX.clear();
			choiceDia.setValue("Dia");
			choiceMes.setValue("Mês");
			choiceAno.setValue("Ano");
			this.cpfFX.clear();
			this.telefoneFX.clear();
		});
		this.voltar = new Button("Menu");
		Menu tela2 = new Menu();
		voltar.setOnAction(e -> {
			try {
				tela2.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		//CRIA BOXS
		caracteristicasTela(choiceDia, choiceMes, choiceAno,t);
	}
	private void caracteristicasTela(ChoiceBox<String> choiceDia, ChoiceBox<String> choiceMes,
			ChoiceBox<String> choiceAno,Text t) {
		labeldata = new Label("Data de Nascimento");
		labelcpf = new Label("CPF                                          Telefone");

		HBox hlayout = new HBox(10);

		hlayout.getChildren().add(choiceDia);
		hlayout.getChildren().add(choiceMes);
		hlayout.getChildren().add(choiceAno);
		//hlayout.setAlignment(Pos.CENTER);

		HBox hlayout2 = new HBox(10);

		hlayout2.getChildren().add(this.botaoCadastrar);
		hlayout2.getChildren().add(this.limpar);
		hlayout2.getChildren().add(this.voltar);
		//hlayout2.setAlignment(Pos.CENTER);

		HBox hlayout3 = new HBox(10);

		hlayout3.getChildren().add(cpfFX);
		hlayout3.getChildren().add(telefoneFX);
		//hlayout3.setAlignment(Pos.CENTER);

		VBox vlayout = new VBox(10);
		vlayout.getChildren().add(t);
		labelnome = new Label("Nome");
		vlayout.getChildren().add(labelnome);
		vlayout.getChildren().add(nomeFX);
		vlayout.getChildren().addAll(labeldata,hlayout);
		vlayout.getChildren().add(labelcpf);
		vlayout.getChildren().add(hlayout3);
		vlayout.getChildren().add(hlayout2);
		vlayout.setPadding(new Insets(20,20,20,20));
		//vlayout.setAlignment(Pos.CENTER);

		//TAMANHO DA TELA
		Scene cena = new Scene(vlayout,400,400);
		cena.getStylesheets().add("DarkTheme.css");

		telaCadastro.setScene(cena);
		telaCadastro.show();
	}

	private boolean validaCampos(String dia,String mes, String ano,String telefone, String cpf, String nome) {
		if(nome.matches("^[a-zA-Z ]+$") == false){
			caixaMensagemDeErro("Nome não pode conter símbolos ou números !", "Information!");
			return false;
		}
		else if(nome.contains(" ") == false){
			caixaMensagemDeErro("Nome faltando sobrenome!", "Information!");
			return false;
		}
		else if(dia.equals("Dia")){
			caixaMensagemDeErro("Campo de dia vazio", "Information!");
			return false;
		}
		else if(mes.equals("Mês")){
			caixaMensagemDeErro("Campo de mês vazio", "Information!");
			return false;
		}
		else if(ano.equals("Ano")){
			caixaMensagemDeErro("Campo de ano vazio", "Information!");
			return false;
		}
		else if (cpf.length() != 11) {
			caixaMensagemDeErro("CPF não pode ter mais que 11 digitos !", "Information!");
			return false;
		}
		else if( telefone.length() != 9 && telefone.length() != 11	&& telefone.length() != 8 ) {
			caixaMensagemDeErro("Campos validos para telefone (xx) 9xxxx-xxx ou 9xxxx-xxxx ou xxxx-xxxx","Information!" );
			return false;
		}
		return true;
	}
	private String getChoice(ChoiceBox<String> choiceBox){
		String valor = choiceBox.getValue();
		return valor;
	}
	public static void caixaMensagemDeErro(String msg, String titulo) {
		Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
		dialogoInfo.setTitle(titulo);
		dialogoInfo.setContentText(msg);
		dialogoInfo.showAndWait();
	}
	public static void caixaMensagemSucess(String msg, String titulo){
		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
		dialogoInfo.setTitle(titulo);
		dialogoInfo.setContentText(msg);
		dialogoInfo.showAndWait();
	}
	/**
	 * Adiciona aluno com todos os dados no formato padrão
	 * @param arrayAluno
	 * @param nome
	 * @param dia
	 * @param mes
	 * @param ano
	 * @param cpf
	 * @param telefone
	 */
	public void adicionaNovoAluno(ObservableList<Aluno> arrayAluno,String nome,int dia, int mes, int ano,String cpf,String telefone){
		//Funcoes.leArquivoTxT(arrayAluno);
		Funcoes.retornaUltimaMatricula(arrayAluno);
		Aluno.numMatricula=Aluno.numMatricula+1;
		System.out.println("Campo cadastro:"+Aluno.numMatricula);
		cpf = Funcoes.formataCPF(cpf);

		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE,dia);
		c.set(Calendar.MONTH,mes);
		c.set(Calendar.YEAR,ano);

		Aluno aux = new Aluno();
		aux.setData(Funcoes.formataData(dia, mes+1, ano));
		aux.setDataNascimento(c);
		
		aux.setNome(nome);
		aux.setMatricula(Integer.toString(Aluno.numMatricula));
		telefone = Funcoes.formataTelefone(telefone);
		aux.setTelefone(telefone);
		aux.setIdade(Funcoes.calculaIdade(c));
		aux.setCPF(cpf);

		arrayAluno.add(aux);
	}
}
