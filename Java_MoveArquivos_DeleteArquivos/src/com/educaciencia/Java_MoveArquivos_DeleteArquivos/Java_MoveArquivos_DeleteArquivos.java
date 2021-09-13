package com.educaciencia.Java_MoveArquivos_DeleteArquivos;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class Java_MoveArquivos_DeleteArquivos {



	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//moverTodosArquivos(); //move arquivos Local para destino 
		//moveArquivoIndividual(); //move unico arquivo Local para destino
		deletarTodosArquivos(); //deleta arquivo pasta local

	}

	/**************************************************
	 * ************ MANIPULAR ARQUIVOS *****************
	 **************************************************/

	public static void moverTodosArquivos() throws IOException {

		File pathDestino = new File("C:\\educaciencia\\arquivoMovido");
		File pathOrigem = new File("C:\\educaciencia\\");
		
		if (!pathDestino.exists()) {
			pathDestino.mkdirs();
		}else {
			System.out.println("Não há arquivos !");
		}

		// Check weather source exists and it is folder.
		if (pathOrigem.exists() && pathOrigem.isDirectory()) {
			// Get list of the files and iterate over them
			File[] listOfFiles = pathOrigem.listFiles();

			if (listOfFiles != null) {
				for (File child : listOfFiles) {
					// Move files to destination folder
					child.renameTo(new File(pathDestino + "\\" + child.getName()));
				}

				// Add if you want to delete the source folder
				pathOrigem.delete();
			}
		} else {
			System.out.println(pathOrigem + "  Pasta inexistente");
		}
	}

	public static void moveArquivoIndividual() throws IOException {

		// Arquivo a ser movido
		File arquivo = new File("C:\\educaciencia\\teste.txt");
		
		if (!arquivo.exists()) {
			System.out.println("Arquivo não encontrado");
		} else {

			// Diretorio de destino
			File diretorioDestino = new File("C:\\educaciencia\\arquivoMovido");

			// Move o arquivo para o novo diretorio
			boolean sucesso = arquivo.renameTo(new File(diretorioDestino, arquivo.getName()));
			if (sucesso) {
				System.out.println("Arquivo movido para '" + diretorioDestino.getAbsolutePath() + "'");
			} else {
				System.out.println("Erro ao mover arquivo '" + arquivo.getAbsolutePath() + "' para '"
						+ diretorioDestino.getAbsolutePath() + "'");
			}
		}
	}

	public static void deletarTodosArquivos() throws IOException {

		File pathOrigem = new File("C:\\educaciencia\\");
	
		FileFilter ff = new FileFilter() {
			public boolean accept(File arquivo) {
				return arquivo.getName().endsWith(".txt") || arquivo.getName().endsWith(".xlsx");
			}
		};

		File[] arquivos = pathOrigem.listFiles(ff);
		if (arquivos != null) {
			for (File arquivo : arquivos) {
				arquivo.delete();

			}
		}else {
			System.out.println("Não há arquivos !");
		}
	}

}