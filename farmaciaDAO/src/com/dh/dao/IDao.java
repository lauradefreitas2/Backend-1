package com.dh.dao;

/*
Interface DAO deve conter todos o metodos que fazem CRUD (Operacao de INSERIR, BUSCAR, ATUALIZAR e DELETAR, basicamente)
com o bando de dados. No exemplo temos somente o metodo salvar, mas poderiamos ter uma deletar, buscar e atualizar se houvesse
necessidade.
Tipificamos de forma generica nossa classe, para que outras classes (models) pudessem usar caso fizessem as mesmas operacoes
com o banco de dados.

E quem implementar esse interface, obrigatoriamente precisara implementar todos os seus metodos;
 */
public interface IDao <T>{

    T salvar(T t);
}
