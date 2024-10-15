package br.com.selecao.locadora.base;

public interface TypeMessage {
	String erroInterno = "Encontramos um erro interno! Aguarde enquanto trabalhamos para resolver.";

	String registroNaoEncontrado = "Registro não encontrado.";

	String criadoSucesso = "Registro criado com sucesso.";

	String excluidoSucesso = "Registro apagado com sucesso.";

	String atualizadoSucesso = "Registro atualizado com sucesso.";

	String criadoFalha = "Falha ao criar registro!";

	String atualizadoFalha = "Falha ao atualizar registro!";

	String excluidoFalha = "Falha ao excluir registro!";
}

