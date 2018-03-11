package aluno;

import java.util.Calendar;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javafx.collections.ObservableList;

public class Funcoes {
	static File file = new File("ListagemAlunos.txt");
	static String s = file.getAbsolutePath();
	public static String arquivo = s;
	/**
	 * Formata deixando a primeira letra nome e sobrenome maiúsculas
	 * @param nome
	 * @return
	 */
	public static String formataNome(String nome) {
		String[] arrayNome;
		arrayNome = nome.split(" ");

		for (int i = 0; i < arrayNome.length; i++) {
			arrayNome[i] = arrayNome[i].substring(0,1).toUpperCase().concat(arrayNome[i].substring(1));
		}
		nome = "";
		for (int i = 0; i < arrayNome.length; i++) {
			nome = nome.concat(arrayNome[i])+" ";
		}
		return nome;
	}
	/**
	 * Formata a data no formato DD/MM/YYYY
	 * @param dia
	 * @param mes
	 * @param ano
	 * @return
	 */
	public static String formataData(int dia, int mes, int ano) {
		String _dia = Integer.toString(dia);
		String _mes = Integer.toString(mes);
		String _ano = Integer.toString(ano);
		String stringFormatada = _dia+"/"+_mes+"/"+_ano;

		return stringFormatada;
	}
	/**
	 * Método que formata CPF no formato padrão
	 * @param cpf
	 * @return
	 */
	public static String formataCPF(String cpf) {
		// 
		String parte1 = cpf.substring(0, 3);
		String parte2 = cpf.substring(3, 6);
		String parte3 = cpf.substring(6, 9);
		String parte4 = cpf.substring(9, 11);
		cpf = parte1 + "." + parte2 + "." + parte3 + "-" + parte4;
		return cpf;
	}
	/**
	 * Método que formata telefone no formato padrão
	 * @param telefone
	 * @return
	 */
	public static String formataTelefone(String telefone) {
		if(telefone.length()==11){
			String parte1 = telefone.substring(0, 2);
			String parte2 = telefone.substring(2, 7);
			String parte3 = telefone.substring(7, 11);
			telefone = "(" + parte1 + ")" + " " + parte2 + "-" + parte3;
			return telefone;
		}else if(telefone.length()==8){
			String parte1 = telefone.substring(0, 4);
			String parte2 = telefone.substring(4, 8);
			telefone = parte1 + "-" + parte2;
			return telefone;
		}else if(telefone.length()==9){
			String parte1 = telefone.substring(0, 5);
			String parte2 = telefone.substring(5, 9);
			telefone = parte1 + "-" + parte2;
			return telefone;
		}
		return telefone;

	}
	/**
	 * Método que calcula a idade de acordo com a data atual do computador
	 * @param dataNasc
	 * @return
	 */
	public static int calculaIdade(Calendar dataNasc) {
		Calendar dataNascimento = Calendar.getInstance();  
		dataNascimento = dataNasc;
		Calendar hoje = Calendar.getInstance();  

		int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR); 
		if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
			idade--;  
		} 
		else if (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
			idade--; 
		}
		return idade;
	}
	/**
	 * Sobreescreve para atualizar o aluno removido
	 * @param arrayAluno
	 * @param sobreescreve
	 */
	public static void remove(ObservableList<Aluno> arrayAluno,boolean sobreescreve)
	{
		try
		{
			Aluno aux;
			Writer writer = new FileWriter(arquivo,sobreescreve);
			for (Iterator<Aluno> iterator = arrayAluno.iterator(); iterator.hasNext();) {

				aux = (Aluno) iterator.next();
				String StringIdade = Integer.toString(aux.getIdade());

				writer.append(aux.getMatricula());
				writer.append(";");
				writer.append(aux.getNome());
				writer.append(';');
				writer.append(StringIdade);
				writer.append(";");
				writer.append(aux.getData());
				writer.append(";");
				writer.append(aux.getTelefone());
				writer.append(";");
				writer.append(aux.getCPF());
				writer.append("\n");
				writer.flush();
			}
			writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		} 
	}
	/**
	 * Le o arquivo txt
	 * @param arrayAluno
	 */
	public static void leArquivoTxT(ObservableList<Aluno> arrayAluno) {
		arrayAluno.clear();
		int j=0;
		try{
			BufferedReader br = new BufferedReader(new FileReader(arquivo));
			while(br.ready()){
				int i = 0;

				String linha = br.readLine();
				String[] arrayString;
				arrayString = linha.split(";");
				Aluno aux=new Aluno();
				aux.setMatricula(arrayString[i]);
				i++;
				aux.setNome(arrayString[i]);
				i++;
				aux.setIdade(Integer.parseInt(arrayString[i]));
				i++;
				aux.setData(arrayString[i]);
				i++;
				aux.setTelefone(arrayString[i]);
				i++;
				aux.setCPF(arrayString[i]);

				arrayAluno.add(j, aux);
				j++;
			}
			br.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	/**
	 * Input no arquivo de texto
	 * @param arrayAluno
	 * @param sobreescreve
	 * @param nome
	 * @param auxdia
	 * @param auxmes
	 * @param auxano
	 * @param cpf
	 * @param telefone
	 */
	public static void escreveNoArquivo(ObservableList<Aluno> arrayAluno,boolean sobreescreve,String nome,int auxdia,int auxmes,int auxano,String cpf,String telefone)
	{
		try
		{
			//retornaUltimaMatricula(arrayAluno);
			leArquivoTxT(arrayAluno);
			Aluno aux;
			Writer writer = new FileWriter(arquivo,sobreescreve);

			String matric;
			matric = Integer.toString(Aluno.numMatricula);
			aux = new Aluno();

			cpf = Funcoes.formataCPF(cpf);

			Calendar c = Calendar.getInstance();
			c.set(Calendar.DATE,auxdia);
			c.set(Calendar.MONTH,auxmes);
			c.set(Calendar.YEAR,auxano);

			aux.setData(Funcoes.formataData(auxdia, auxmes+1, auxano));
			aux.setDataNascimento(c);
			aux.setNome(nome);
			telefone = Funcoes.formataTelefone(telefone);
			aux.setTelefone(telefone);
			aux.setIdade(Funcoes.calculaIdade(c));
			String StringIdade = Integer.toString(aux.getIdade());
			aux.setCPF(cpf);

			writer.append(matric);
			writer.append(";");
			writer.append(aux.getNome());
			writer.append(';');
			writer.append(StringIdade);
			writer.append(";");
			writer.append(aux.getData());
			writer.append(";");
			writer.append(aux.getTelefone());
			writer.append(";");
			writer.append(aux.getCPF());
			writer.append("\n");
			writer.flush();
			writer.close();
		}
		catch(IOException e){
			e.printStackTrace();
		} 
	}
	/**
	 * Recebe a última matrícula para ser usado na função cadastrar
	 * @param arrayAluno
	 */
	public static void retornaUltimaMatricula(ObservableList<Aluno> arrayAluno){
		Aluno aux;
		leArquivoTxT(Aluno.arrayAluno);
		int numMatricula=0;
		for (Iterator<Aluno> iterator = arrayAluno.iterator(); iterator.hasNext();) {
			aux = (Aluno) iterator.next();
			if(Integer.parseInt(aux.getMatricula()) > numMatricula){
				numMatricula = Integer.parseInt(aux.getMatricula());
			}
		}
		Aluno.numMatricula = numMatricula;
	}
}
