<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<xsl:variable name="fo:layout-master-set">
		<fo:layout-master-set>
			<fo:simple-page-master master-name="A4-portrait"
				master-reference="default-page" page-height="11in" page-width="8.5in"
				margin-left="0.6in" margin-right="0.6in">
				<fo:region-body margin-top="0.79in" margin-bottom="0.79in"
					font-family="Helvetica,Times,Courier" font-size="14pt" />
			</fo:simple-page-master>
		</fo:layout-master-set>
	</xsl:variable>
	<xsl:template match="/">
		<fo:root>
			<xsl:copy-of select="$fo:layout-master-set" />
			<fo:page-sequence master-reference="A4-portrait"
				master-name="default-page" initial-page-number="1">
				<fo:flow flow-name="xsl-region-body">
					<fo:block>
						<fo:block>
							<xsl:text>&#xA;</xsl:text>
						</fo:block>
						<fo:table background-color="white" width="100%"
							space-before.optimum="1pt" space-after.optimum="2pt">
							<fo:table-column column-width="18.5cm" />
							<fo:table-body>
								<fo:table-row>
									<fo:table-cell padding-after="0pt"
										padding-before="0pt" text-align="center" width="18.5cm"
										padding-start="3pt" padding-end="3pt" border-style="solid"
										border-width="1pt" border-color="gray">
										<fo:block>
											<fo:inline font-size="10pt" font-weight="bold">Shipment Note</fo:inline>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>
						</fo:table>
						<fo:block>
							<fo:leader leader-pattern="space" />
						</fo:block>
						<fo:block>
							<xsl:text>&#xA;</xsl:text>
						</fo:block>
						<fo:table width="100%" space-before.optimum="1pt"
							space-after.optimum="2pt">
							<fo:table-column column-width="1.1cm" />
							<fo:table-column column-width="1.1cm" />
							<fo:table-column column-width="1.1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1cm" />
							<fo:table-column column-width="1.1cm" />
							<fo:table-column column-width="1.1cm" />
							<fo:table-body>
								<fo:table-row>
									<fo:table-cell border-after-color="gray"
										border-before-color="gray" border-end-color="gray"
										border-start-color="gray" padding-after="0pt" padding-before="0pt"
										number-columns-spanned="9" width="1.1cm" padding-start="3pt"
										padding-end="3pt" text-align="start" border-style="solid"
										border-width="1pt" border-color="gray">
										<fo:block>
											<fo:inline border-after-color="gray"
												border-before-color="gray" border-end-color="gray"
												border-start-color="gray" font-size="8pt">Shipment No :
											</fo:inline>
											<xsl:for-each select="ShipmentOrder/ShippingDocs/Document/Number">
												<xsl:if test="../Name  = &quot;DeliveryNote&quot;">
													<fo:inline border-after-color="gray"
														border-before-color="gray" border-end-color="gray"
														border-start-color="gray" font-size="8pt">
														<xsl:apply-templates />
													</fo:inline>
												</xsl:if>
											</xsl:for-each>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell border-after-color="gray"
										border-before-color="gray" border-end-color="gray"
										border-start-color="gray" padding-after="0pt" padding-before="0pt"
										number-columns-spanned="9" width="1.1cm" padding-start="3pt"
										padding-end="3pt" text-align="start" border-style="solid"
										border-width="1pt" border-color="gray">
										<fo:block>
											<fo:inline border-after-color="gray"
												border-before-color="gray" border-end-color="gray"
												border-start-color="gray" font-size="8pt">Shipment Date :
											</fo:inline>

											<xsl:for-each
												select="ShipmentOrder/ShippingDocs/Document/ShippingDate">
												<xsl:if test="../Name  = &quot;DeliveryNote&quot;">
													<fo:inline border-after-color="gray"
														border-before-color="gray" border-end-color="gray"
														border-start-color="gray" font-size="8pt">
														<xsl:apply-templates />
													</fo:inline>
												</xsl:if>
											</xsl:for-each>

										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell border-after-color="gray"
										border-before-color="gray" border-end-color="gray"
										border-start-color="gray" padding-after="0pt" padding-before="0pt"
										number-columns-spanned="9" width="1.1cm" padding-start="3pt"
										padding-end="3pt" text-align="start" border-style="solid"
										border-width="1pt" border-color="gray">
										<fo:block>
											<fo:inline border-after-color="gray"
												border-before-color="gray" border-end-color="gray"
												border-start-color="gray" font-size="8pt">Deliver Date :
											</fo:inline>
											<xsl:for-each
												select="ShipmentOrder/ShippingDocs/Document/GeneratedDate">
												<xsl:if test="../Name  = &quot;DeliveryNote&quot;">
													<fo:inline border-after-color="gray"
														border-before-color="gray" border-end-color="gray"
														border-start-color="gray" font-size="8pt">
														<xsl:apply-templates />
													</fo:inline>
												</xsl:if>
											</xsl:for-each>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell border-after-color="gray"
										border-before-color="gray" border-end-color="gray"
										border-start-color="gray" padding-after="0pt" padding-before="0pt"
										number-columns-spanned="9" width="1.1cm" padding-start="3pt"
										padding-end="3pt" text-align="start" border-style="solid"
										border-width="1pt" border-color="gray">
										<fo:block>
											<fo:inline border-after-color="gray"
												border-before-color="gray" border-end-color="gray"
												border-start-color="gray" font-size="8pt">Shipping Mode : </fo:inline>
											<xsl:for-each select="ShipmentOrder/Carrier/Description">
												<fo:inline border-after-color="gray"
													border-before-color="gray" border-end-color="gray"
													border-start-color="gray" font-size="8pt">
													<xsl:apply-templates />
												</fo:inline>
											</xsl:for-each>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								
								<fo:table-row>
									<fo:table-cell border-after-color="gray"
										border-before-color="gray" border-end-color="gray"
										border-start-color="gray" padding-after="0pt" padding-before="0pt"
										number-columns-spanned="9" width="1.1cm" padding-start="3pt"
										padding-end="3pt" text-align="start" border-style="solid"
										border-width="1pt" border-color="gray">
										<fo:block>
											<fo:inline border-after-color="gray"
												border-before-color="gray" border-end-color="gray"
												border-start-color="gray" font-size="8pt">Source Company Name :
											</fo:inline>
											<xsl:for-each select="ShipmentOrder/Shipment/ShipFrom/CompanyName">
												<fo:inline border-after-color="gray"
													border-before-color="gray" border-end-color="gray"
													border-start-color="gray" font-size="8pt">
													<xsl:apply-templates />
												</fo:inline>
											</xsl:for-each>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell border-after-color="gray"
										border-before-color="gray" border-end-color="gray"
										border-start-color="gray" padding-after="0pt" padding-before="0pt"
										number-columns-spanned="9" width="1.1cm" padding-start="3pt"
										padding-end="3pt" text-align="start" border-style="solid"
										border-width="1pt" border-color="gray">
										<fo:block>
											<fo:inline border-after-color="gray"
												border-before-color="gray" border-end-color="gray"
												border-start-color="gray" font-size="8pt">Destination Company Name :
											</fo:inline>
											<xsl:for-each select="ShipmentOrder/Shipment/ShipTo/CompanyName">
												<fo:inline border-after-color="gray"
													border-before-color="gray" border-end-color="gray"
													border-start-color="gray" font-size="8pt">
													<xsl:apply-templates />
												</fo:inline>
											</xsl:for-each>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
								<fo:table-row>
									<fo:table-cell border-after-color="gray"
										border-before-color="gray" border-end-color="gray"
										border-start-color="gray" padding-after="0pt" padding-before="0pt"
										number-columns-spanned="9" width="1.1cm" padding-start="3pt"
										padding-end="3pt" text-align="start" border-style="solid"
										border-width="1pt" border-color="gray">
										<fo:block>
											<fo:inline border-after-color="gray"
												border-before-color="gray" border-end-color="gray"
												border-start-color="gray" font-size="8pt">Source Address : </fo:inline>
											<xsl:for-each select="ShipmentOrder/Shipment/ShipFrom/Address">
												<xsl:for-each select="AddressLine1">
													<fo:inline border-after-color="gray"
														border-before-color="gray" border-end-color="gray"
														border-start-color="gray" font-size="8pt">
														<xsl:apply-templates />
													</fo:inline>
												</xsl:for-each>
											</xsl:for-each>
											<xsl:for-each select="ShipmentOrder/Shipment/ShipTo/Address">
												<xsl:for-each select="AddressLine2">
													<fo:inline border-after-color="gray"
														border-before-color="gray" border-end-color="gray"
														border-start-color="gray" font-size="8pt">
														<xsl:apply-templates />
													</fo:inline>
												</xsl:for-each>
											</xsl:for-each>
											<xsl:for-each select="ShipmentOrder/Shipment/ShipFrom/Address">
												<xsl:for-each select="AddressLine3">
													<fo:inline border-after-color="gray"
														border-before-color="gray" border-end-color="gray"
														border-start-color="gray" font-size="8pt">
														<xsl:apply-templates />
													</fo:inline>
												</xsl:for-each>
											</xsl:for-each>
											<xsl:for-each select="ShipmentOrder/Shipment/ShipFrom/Address">
												<xsl:for-each select="City">
													<fo:inline border-after-color="gray"
														border-before-color="gray" border-end-color="gray"
														border-start-color="gray" font-size="8pt">
														<xsl:apply-templates />
													</fo:inline>
												</xsl:for-each>
											</xsl:for-each>
											<xsl:for-each select="ShipmentOrder/Shipment/ShipFrom/Address">
												<xsl:for-each select="StateProvinceCode">
													<fo:inline border-after-color="gray"
														border-before-color="gray" border-end-color="gray"
														border-start-color="gray" font-size="8pt">
														<xsl:apply-templates />
													</fo:inline>
												</xsl:for-each>
											</xsl:for-each>
											<xsl:for-each select="ShipmentOrder/Shipment/ShipFrom/Address">
												<xsl:for-each select="PostalCode">
													<fo:inline border-after-color="gray"
														border-before-color="gray" border-end-color="gray"
														border-start-color="gray" font-size="8pt">
														<xsl:apply-templates />
													</fo:inline>
												</xsl:for-each>
											</xsl:for-each>
											<xsl:for-each select="ShipmentOrder/Shipment/ShipFrom/Address">
												<xsl:for-each select="CountryCode">
													<fo:inline border-after-color="gray"
														border-before-color="gray" border-end-color="gray"
														border-start-color="gray" font-size="8pt">
														<xsl:apply-templates />
													</fo:inline>
												</xsl:for-each>
											</xsl:for-each>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell border-after-color="gray"
										border-before-color="gray" border-end-color="gray"
										border-start-color="gray" padding-after="0pt" padding-before="0pt"
										number-columns-spanned="9" width="1.1cm" padding-start="3pt"
										padding-end="3pt" text-align="start" border-style="solid"
										border-width="1pt" border-color="gray">
										<fo:block>
											<fo:inline border-after-color="gray"
												border-before-color="gray" border-end-color="gray"
												border-start-color="gray" font-size="8pt">Destination Address :&#160;
											</fo:inline>
											<xsl:for-each select="ShipmentOrder/Shipment/ShipTo/Address">
												<xsl:for-each select="AddressLine1">
													<fo:inline border-after-color="gray"
														border-before-color="gray" border-end-color="gray"
														border-start-color="gray" font-size="8pt">
														<xsl:apply-templates />
													</fo:inline>
												</xsl:for-each>
											</xsl:for-each>
											<xsl:for-each select="ShipmentOrder/Shipment/ShipTo/Address">
												<xsl:for-each select="AddressLine2">
													<fo:inline border-after-color="gray"
														border-before-color="gray" border-end-color="gray"
														border-start-color="gray" font-size="8pt">
														<xsl:apply-templates />
													</fo:inline>
												</xsl:for-each>
											</xsl:for-each>
											<xsl:for-each select="ShipmentOrder/Shipment/ShipTo/Address">
												<xsl:for-each select="AddressLine3">
													<fo:inline border-after-color="gray"
														border-before-color="gray" border-end-color="gray"
														border-start-color="gray" font-size="8pt">
														<xsl:apply-templates />
													</fo:inline>
												</xsl:for-each>
											</xsl:for-each>
											<xsl:for-each select="ShipmentOrder/Shipment/ShipTo/Address">
												<xsl:for-each select="City">
													<fo:inline border-after-color="gray"
														border-before-color="gray" border-end-color="gray"
														border-start-color="gray" font-size="8pt">
														<xsl:apply-templates />
													</fo:inline>
												</xsl:for-each>
											</xsl:for-each>
											<xsl:for-each select="ShipmentOrder/Shipment/ShipTo/Address">
												<xsl:for-each select="StateProvinceCode">
													<fo:inline border-after-color="gray"
														border-before-color="gray" border-end-color="gray"
														border-start-color="gray" font-size="8pt">
														<xsl:apply-templates />
													</fo:inline>
												</xsl:for-each>
											</xsl:for-each>
											<xsl:for-each select="ShipmentOrder/Shipment/ShipTo/Address">
												<xsl:for-each select="PostalCode">
													<fo:inline border-after-color="gray"
														border-before-color="gray" border-end-color="gray"
														border-start-color="gray" font-size="8pt">
														<xsl:apply-templates />
													</fo:inline>
												</xsl:for-each>
											</xsl:for-each>
											<xsl:for-each select="ShipmentOrder/Shipment/ShipTo/Address">
												<xsl:for-each select="CountryCode">
													<fo:inline border-after-color="gray"
														border-before-color="gray" border-end-color="gray"
														border-start-color="gray" font-size="8pt">
														<xsl:apply-templates />
													</fo:inline>
												</xsl:for-each>
											</xsl:for-each>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>
						</fo:table>
						<fo:block>
							<xsl:text>&#xA;</xsl:text>
						</fo:block>
						
						<fo:block>
							<xsl:text>&#xA;</xsl:text>
						</fo:block>
						<fo:table width="100%" space-before.optimum="5pt"
							space-after.optimum="2pt">
							<fo:table-column column-width="5cm" />
							<fo:table-column column-width="13.5cm" />
							<fo:table-body>
								<fo:table-row>
									<fo:table-cell border-after-color="gray"
										border-before-color="gray" border-end-color="gray"
										border-start-color="gray" padding-after="0pt" padding-before="0pt"
										width="5cm" padding-start="3pt" padding-end="3pt" text-align="start"
										border-style="solid" border-width="1pt" border-color="gray">
										<fo:block>
											<fo:inline font-size="8pt">Total Items</fo:inline>
										</fo:block>
									</fo:table-cell>
									<fo:table-cell border-after-color="gray"
										border-before-color="gray" border-end-color="gray"
										border-start-color="gray" padding-after="0pt" padding-before="0pt"
										padding-start="3pt" padding-end="3pt" text-align="start"
										border-style="solid" border-width="1pt" border-color="gray">
										<fo:block>
											<fo:inline font-size="8pt">
												<xsl:value-of
													select="/ShipmentOrder/Shipment/Package/PackageItems" />
											</fo:inline>
										</fo:block>
									</fo:table-cell>
								</fo:table-row>
							</fo:table-body>
						</fo:table>
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
</xsl:stylesheet>
