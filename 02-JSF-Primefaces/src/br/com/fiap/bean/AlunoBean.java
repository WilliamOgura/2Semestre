package br.com.fiap.bean;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.fiap.bo.AlunoBO;
import br.com.fiap.entity.Aluno;
@SessionScoped
@ManagedBean
public class AlunoBean {
	
	private Aluno aluno;
	private AlunoBO bo;
	private StreamedContent imagem;
	@PostConstruct
	private void init(){
		aluno = new Aluno();
		aluno.setDataNascimento(Calendar.getInstance());
		bo = new AlunoBO();
	}

	public String cadastrar(){
		FacesMessage msg ;
		try {
			bo.cadastrar(aluno);
			msg = new FacesMessage("Cadastrado!");
			init();
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro!");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "aluno?faces-redirect=true";
	}
	
	public String alterar(){
		FacesMessage msg ;
		try {
			bo.atualizar(aluno);
			msg = new FacesMessage("Alterado!");
			
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro!");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "lista-aluno?faces-redirect=true";
	}
	
	public void uploadFile(FileUploadEvent event){
		aluno.setFoto(event.getFile().getContents());
		
		/*String arquivo = event.getFile().getFileName();
	try{
		File file = new File("C:\\fotos\\",arquivo);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(event.getFile().getContents());
		fos.close();
		aluno.setFoto(arquivo);
	}catch (Exception e) {
		e.printStackTrace();
	}*/
	}
	
	
	
	//retorna a imagem para exibir na página

	public StreamedContent getImagem(){
				
		DefaultStreamedContent content = new DefaultStreamedContent();
		content.setContentType("image/jpg");
		try {
		if(FacesContext.getCurrentInstance().getRenderResponse()|| aluno.getFoto()==null){
			//foto padrão
			
				content.setStream(new FileInputStream("C:\\fotos\\padrao.jpg"));

		}else{
			//content.setStream(new FileInputStream("C:\\fotos\\"+aluno.getFoto()));
			content.setStream(new ByteArrayInputStream(aluno.getFoto()));
		}
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
		return content;
		}
	 
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	

}
