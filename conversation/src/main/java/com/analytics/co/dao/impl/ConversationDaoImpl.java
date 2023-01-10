/**
 * 
 */
package com.analytics.co.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.analytics.co.dao.ConversationDao;

import co.com.claro.schema.analytics.cnvr.response.ResponseConversation;
import co.com.claro.schema.util.ResponseCodes;

/**
 * Data Access Object class
 * 
 * You should only perform database transactions
 * 
 * @author Andres Capera
 * @version 0.1
 *
 */
@Repository
@Transactional
public class ConversationDaoImpl implements ConversationDao {

	private static final Logger logger = Logger.getLogger(ConversationDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public Session getSession() {
		return entityManager.unwrap(Session.class);
	}



	/**
	 * 
	 * Conversation record method in Jsondoc table
	 * 
	 * @param data
	 * @return ResponseConversationSP
	 */
	public ResponseConversation insertUpdConversationSPJs(String data) {
		ResponseConversation requesInfoGeneral = new ResponseConversation();
		String message = "";
		String sql = " INSERT INTO \"CNVR\".\"JSONDOCS\" (\"doc\") VALUES (?)";
		try {
			entityManager.createNativeQuery(sql).setParameter(1, data).executeUpdate();
			requesInfoGeneral.setStatusResponse(ResponseCodes.SUCCESS);
		} catch (Exception e) {
			requesInfoGeneral.setStatusResponse(ResponseCodes.DATABASE_EXCEPTION);
			message = "insertUpdConversationSPJs" + e.getMessage() + e.getCause();
			logger.error(message);

		}

		return requesInfoGeneral;

	}

}
