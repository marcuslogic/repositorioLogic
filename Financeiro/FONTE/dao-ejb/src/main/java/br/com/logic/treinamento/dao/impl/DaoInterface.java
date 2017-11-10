package br.com.logic.treinamento.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;

public interface DaoInterface<T extends Serializable> {

    ArrayList<T> getSaidas() throws Exception;
}