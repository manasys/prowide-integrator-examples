/*
 * Copyright (c) http://www.prowidesoftware.com/, 2013. All rights reserved.
 */
package com.prowidesoftware.swift.samples;

import java.io.StringWriter;

import com.prowidesoftware.swift.io.ConversionService;
import com.prowidesoftware.swift.io.writer.XMLWriterVisitor;

/**
 * Example of message conversion to XML representation.
 * Notice this is not SWIFT MX format, but the internal/proprietary XML representation defined at WIFE.
 * 
 * <p>running this sample will generate something like:</p>
 * <em>Note the element <code>field</code> inside block4 instead of <code>tag</code>
 * <pre>

<message>
<block1>
	<applicationId>F</applicationId>
	<serviceId>01</serviceId>
	<logicalTerminal>BICFOOYYAXXX</logicalTerminal>
	<sessionNumber>8683</sessionNumber>
	<sequenceNumber>497519</sequenceNumber>
</block1>
<block2 type="output">
	<messageType>103</messageType>
	<senderInputTime>1535</senderInputTime>
	<MIRDate>051028</MIRDate>
	<MIRLogicalTerminal>ESPBESMMAXXX</MIRLogicalTerminal>
	<MIRSessionNumber>5423</MIRSessionNumber>
	<MIRSequenceNumber>752247</MIRSequenceNumber>
	<receiverOutputDate>051028</receiverOutputDate>
	<receiverOutputTime>1535</receiverOutputTime>
	<messagePriority>N</messagePriority>
</block2>
<block3>
	<tag>
		<name>113</name>
		<value>ROMF</value>
	</tag>
	<tag>
		<name>108</name>
		<value>0510280182794665</value>
	</tag>
	<tag>
		<name>119</name>
		<value>STP</value>
	</tag>
</block3>
<block4>
	<field>
		<name>20</name>
		<component number="1">0061350113089908</component>
	</field>
	<field>
		<name>13C</name>
		<component number="1">RNCTIME</component>
		<component number="2">1534</component>
		<component number="3">+</component>
		<component number="4">0000</component>
	</field>
	<field>
		<name>23B</name>
		<component number="1">CRED</component>
	</field>
	<field>
		<name>23E</name>
		<component number="1">SDVA</component>
		<component number="2">null</component>
	</field>
	<field>
		<name>72</name>
		<component number="1">/BNF/TRANSF. BCO. FOO</component>
		<component number="2">null</component>
		<component number="3">null</component>
		<component number="4">null</component>
		<component number="5">null</component>
		<component number="6">null</component>
		<component number="7">null</component>
		<component number="8">null</component>
		<component number="9">null</component>
		<component number="10">null</component>
		<component number="11">null</component>
		<component number="12">null</component>
		<component number="13">null</component>
		<component number="14">null</component>
		<component number="15">null</component>
		<component number="16">null</component>
		<component number="17">null</component>
		<component number="18">null</component>
		<component number="19">null</component>
		<component number="20">null</component>
		<component number="21">null</component>
		<component number="22">null</component>
		<component number="23">null</component>
		<component number="24">null</component>
		<component number="25">null</component>
		<component number="26">null</component>
		<component number="27">null</component>
		<component number="28">null</component>
		<component number="29">null</component>
		<component number="30">null</component>
		<component number="31">null</component>
		<component number="32">null</component>
		<component number="33">null</component>
		<component number="34">null</component>
		<component number="35">null</component>
	</field>
</block4>
<block5>
	<tag>
		<name>MAC</name>
		<value>88B4F929</value>
	</tag>
	<tag>
		<name>CHK</name>
		<value>22EF370A4073</value>
	</tag>
</block5>
</message>


</pre> 
 * @author www.prowidesoftware.com
 */
public class MessageRichXMLConversionExample {

	public static void main(String[] args) {
		ConversionService srv = new ConversionService();
		String fin = "{1:F01BICFOOYYAXXX8683497519}{2:O1031535051028ESPBESMMAXXX54237522470510281535N}{3:{113:ROMF}{108:0510280182794665}{119:STP}}{4:\n" + 
				":20:0061350113089908\n" + 
				":13C:/RNCTIME/1534+0000\n" + 
				":23B:CRED\n" + 
				":23E:SDVA\n" + 
				":72:/BNF/TRANSF. BCO. FOO\n" + 
				"-}{5:{MAC:88B4F929}{CHK:22EF370A4073}}\n" + 
				"\n" ;
		
		// This will switch on a more detailed output in the xml, ideal for processing elements inside each tag
		boolean useFieldInsteadOfTag = true;
		String xml = srv.getXml(fin, useFieldInsteadOfTag);
		System.out.println(xml);
		
	}
}
