<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/ShipmentOrder">
		<html>
		<META http-equiv="content-type" content="text/html; charset=UTF-8" />

			
			<title>Delivery Note</title>
			<object ID="WB" WIDTH="0" HEIGHT="0" CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"/>
			<form action="" method="post" name="frmManifest" id="frmManifest">
				<table border="0" cellspacing="1" width="700px" height="1px" cellpadding="0" align="center" valign="top">
					<tr>
						<td>
							<table border="0" cellspacing="1" width="100%" cellpadding="0" align="center" valign="top">
								<tr>
									<td>
										<table border="0" cellspacing="1" cellpadding="1" width="100%">
											<tr>
												<td valign="top">
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
												</td>
											</tr>
											<tr>
												<td>
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
												</td>
											</tr>
											<tr>
												<td>
													
												</td>
											</tr>
											<tr>
												<td align="center" background="images/gray_px.GIF">
													<span class="bold">Shipment Note</span>
												</td>
											</tr>
											<tr>
												<td>
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<table border="0" cellspacing="1" width="100%" cellpadding="0" align="center" valign="top">
								<tr>
									<td background="images/gray_px.GIF">
										<table border="0" cellspacing="1" cellpadding="0" width="100%">
											<tr>
												<td class="tblcell" width="32%">
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													Shipment No :
													<xsl:for-each select="ShippingDocs/Document">
														<xsl:if test="Name = 'DeliveryNote' ">
															<xsl:value-of select="Number"/>
														</xsl:if>
													</xsl:for-each>
												</td>
												<td class="tblcell" width="18%">
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													Shipment Date :
													<xsl:for-each select="ShippingDocs/Document">
														<xsl:if test="Name = 'DeliveryNote' ">
															<xsl:variable name="d1">
																<xsl:value-of select="normalize-space(ShippingDate)"/>
															</xsl:variable>
															<xsl:if test="contains($d1,' ')">
																<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
																<xsl:value-of select="substring-before($d1,' ')"/>
															</xsl:if>
															<!--<xsl:value-of select="ShippingDate"/> -->
														</xsl:if>
													</xsl:for-each>
												</td>
												
											</tr>
											<!-- wsdsds -->
											<tr>
												<td class="tblcell" width="30%">
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													Deliver Date :
													<xsl:for-each select="ShippingDocs/Document">
														<xsl:if test="Name = 'DeliveryNote' ">
															<xsl:variable name="d1">
																<xsl:value-of select="normalize-space(GeneratedDate)"/>
															</xsl:variable>
															<xsl:if test="contains($d1,' ')">
																<xsl:value-of select="substring-before($d1,' ')"/>
															</xsl:if>
															
														</xsl:if>
													</xsl:for-each>
												</td>
												
												<td class="tblcell" width="20%"/>
											</tr>
											<!-- wsdsds -->
											
											<tr>
												<td class="tblcell" width="30%">
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													Company Name :	
													<xsl:value-of select="Shipment/ShipFrom/CompanyName"/>
												</td>
												
												<td class="tblcell" width="30%">
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													Company Name :
													<xsl:value-of select="Shipment/ShipTo/CompanyName"/>
												</td>
												
											</tr>
											<tr>
												<td class="tblcell" width="30%">
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													Address :
													<xsl:value-of select="Shipment/ShipFrom/Address/AddressLine1"/>
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													<xsl:value-of select="Shipment/ShipFrom/Address/AddressLine2"/>
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													<br/>
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													<xsl:value-of select="Shipment/ShipFrom/Address/City"/>
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													<xsl:value-of select="Shipment/ShipFrom/Address/StateProvinceCode"/>
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													<xsl:value-of select="Shipment/ShipFrom/Address/PostalCode"/>
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													<xsl:value-of select="Shipment/ShipFrom/Address/CountryCode"/>
												</td>
												
												<td class="tblcell" width="30%">
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													Address :		
													<xsl:value-of select="Shipment/ShipTo/Address/AddressLine1"/>
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													<xsl:value-of select="Shipment/ShipTo/Address/AddressLine2"/>
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													<br/>
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													<xsl:value-of select="Shipment/ShipTo/Address/City"/>
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													<xsl:value-of select="Shipment/ShipTo/Address/StateProvinceCode"/>
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													<xsl:value-of select="Shipment/ShipTo/Address/PostalCode"/>
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													<xsl:value-of select="Shipment/ShipTo/Address/CountryCode"/>
												</td>
												
											</tr>
											
											<!-- wsdsds -->
											<td class="tblcell" width="32%">
												<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
											</td>
											<td class="tblcell" width="18%">							
												</td>
											<td class="tblcell" width="32%">							
												</td>
											<td class="tblcell" width="18%">							
											</td>
										</table>
									</td>
								</tr>
							</table>
							
							<table border="0" cellspacing="1" width="100%" cellpadding="0" align="center" valign="top">
								<tr>
									<td valign="top" >
										<table border="0" cellspacing="1" cellpadding="0" width="100%">
											<tr>
												<td class="tblcell" height="20px" width="39%">
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>Total Items
												</td>
												<td class="tblcell" height="20px" width="61%">
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
													<xsl:value-of
													select="/ShipmentOrder/Shipment/Package/PackageItems" />
												</td>
											</tr>
											
										</table>
									</td>
								</tr>
							</table>
							
							
						</td>
					</tr>
				</table>
				
			</form>
		</html>
	</xsl:template>
</xsl:stylesheet>
