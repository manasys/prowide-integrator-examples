/*******************************************************************************
 * Copyright (c) 2019 Prowide Inc.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as 
 *     published by the Free Software Foundation, either version 3 of the 
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 *     
 *     Check the LGPL at <http://www.gnu.org/licenses/> for more details.
 *******************************************************************************/
package com.prowidesoftware.swift.samples.integrator.translations;

import com.prowidesoftware.swift.io.parser.MxParser;
import com.prowidesoftware.swift.model.MxId;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import com.prowidesoftware.swift.model.mx.AbstractMX;
import com.prowidesoftware.swift.translations.Translator;
import com.prowidesoftware.swift.translations.TranslatorFactory;

/**
 * This example shows how to perform automatic translation from a MX to its correspondent MT
 * using API from Prowide Integrator Translations module. Using the generic interface.
 * <br>
 * Example with abstract generic API calls.
 * 
 * @since 7.7
 */
public class MxMtTranslationExample2 {

	public static void main(String[] args) {

		// detect message type
		MxId id = new MxParser(xml).detectMessage();

		// parse the unknown source message
		final AbstractMX source = AbstractMX.parse(xml, id);

		// get a translator for the available equivalent MT
		Translator<AbstractMX, AbstractMT> t = TranslatorFactory.getTranslator(source);

		// check the translator exists
		if (t != null) {

			// call the translation
			AbstractMT mt = t.translate(source);

			// print content from the translated message
			System.out.println(mt.message());
		}

	}

	public final static String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
			"<RequestPayload>\n" +
			" <h:AppHdr xmlns:h=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.01\">\n" +
			"  <h:BizMsgIdr>MYID</h:BizMsgIdr>\n" +
			" </h:AppHdr>\n" +
			" <Doc:Document xmlns:Doc=\"urn:swift:xsd:seev.034.002.02\">\n" +
			"  <Doc:CorpActnInstrStsAdvc>\n" +
			"   <Doc:CorpActnGnlInf>\n" +
			"    <Doc:CorpActnEvtId>777</Doc:CorpActnEvtId>\n" +
			"    <Doc:EvtTp>\n" +
			"     <Doc:Cd>BONU</Doc:Cd>\n" +
			"    </Doc:EvtTp>\n" +
			"   </Doc:CorpActnGnlInf>\n" +
			"   <Doc:InstrPrcgSts>\n" +
			"    <Doc:Accptd>\n" +
			"     <Doc:NoSpcfdRsn>NORE</Doc:NoSpcfdRsn>\n" +
			"    </Doc:Accptd>\n" +
			"   </Doc:InstrPrcgSts>\n" +
			"   <Doc:CorpActnInstr>\n" +
			"    <Doc:OptnNb>\n" +
			"     <Doc:Cd>UNSO</Doc:Cd>\n" +
			"    </Doc:OptnNb>\n" +
			"    <Doc:OptnTp>\n" +
			"     <Doc:Cd>ABST</Doc:Cd>\n" +
			"    </Doc:OptnTp>\n" +
			"    <Doc:InstdBal>\n" +
			"     <Doc:ShrtLngPos>SHOR</Doc:ShrtLngPos>\n" +
			"     <Doc:QtyChc>\n" +
			"      <Doc:Qty>\n" +
			"       <Doc:AmtsdVal>123</Doc:AmtsdVal>\n" +
			"      </Doc:Qty>\n" +
			"     </Doc:QtyChc>\n" +
			"    </Doc:InstdBal>\n" +
			"   </Doc:CorpActnInstr>\n" +
			"  </Doc:CorpActnInstrStsAdvc>\n" +
			" </Doc:Document>\n" +
			"</RequestPayload>";
}
