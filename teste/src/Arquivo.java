import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Arquivo {

	public void escreverArquivo(ArrayList<Pessoa> array) throws FileNotFoundException, IOException{
		try(FileOutputStream fOut = new FileOutputStream("C:/Users/Wennio/workspace/teste/src/pessoa.ser")){
			try(ObjectOutputStream out = new ObjectOutputStream(fOut)){
				out.writeObject(array);
			}
		}
	}
		
	@SuppressWarnings("unchecked")
	public ArrayList<Pessoa> lerArquivo() throws FileNotFoundException, IOException, ClassNotFoundException{
		try(FileInputStream fIn = new FileInputStream("C:/Users/Wennio/workspace/teste/src/pessoa.ser")){
			try(ObjectInputStream in = new ObjectInputStream(fIn)){
				return (ArrayList<Pessoa>) in.readObject();
			}
		}
	}
	
	public void excluirArquivo(int op) throws FileNotFoundException, ClassNotFoundException, IOException{
		ArrayList<Pessoa> pessoa = this.lerArquivo();
		pessoa.remove(pessoa.remove(op));
		this.escreverArquivo(pessoa);
		System.out.println("Arquivo excluido com sucesso! \n\n");
	}

}
