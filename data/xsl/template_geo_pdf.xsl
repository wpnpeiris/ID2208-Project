<?xml version="1.0" encoding="UTF-8" ?>

<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<fo:layout-master-set>
		<fo:simple-page-master page-height="279mm" page-width="216mm" margin-top="10mm" margin-left="20mm" margin-right="20mm" margin-bottom="10mm" master-name="PageMaster">
			<fo:region-body background-color="#EFAFAF" margin-top="20mm" margin-left="10mm" margin-right="10mm" margin-bottom="20mm"/>
		
			<fo:region-before background-color="#EFEFEF" extent="16mm"/>
			<fo:region-after background-color="#EFEFEF" extent="16mm"/>
			<fo:region-start background-color="#EFAFEF" extent="8mm" reference-orientation="270"/>
			<fo:region-end background-color="#EFAFEF" extent="8mm" reference-orientation="270"/>
		</fo:simple-page-master>
	</fo:layout-master-set>
	<fo:page-sequence initial-page-number="1" master-reference="PageMaster">
		<fo:static-content flow-name="xsl-region-start">
			<fo:block font-family="sans-serif" font-size="15pt">left</fo:block>
		</fo:static-content>
		<fo:static-content flow-name="xsl-region-end">
			<fo:block font-family="sans-serif" font-size="15pt">right</fo:block>
		</fo:static-content>
		<fo:static-content flow-name="xsl-region-before">
			<fo:block font-size="7pt">
				<fo:external-graphic src="url('img/antenna-en.png')" content-height="12mm"/>
				XSL FO Sample Copyright &#xA9; 2002-2005 Antenna House, Inc. All rights reserved.
			</fo:block>
		</fo:static-content>
<fo:static-content flow-name="xsl-region-after">
<fo:block text-align="center" font-family="sans-serif" font-size="15pt">bottom</fo:block>
</fo:static-content>
<fo:flow flow-name="xsl-region-body">
<fo:block text-indent="1em" font-family="sans-serif" font-size="20pt" font-weight="bold" background-color="#EEEEEE" line-height="20mm">
Explaining each region in a page
</fo:block>
<fo:block></fo:block>
<fo:block padding-start="3mm" padding-end="3mm">
<fo:block>
One page consists of five regions in XSL-FO.
</fo:block>
<fo:block></fo:block>
<fo:block><fo:inline-container font-weight="bold"><fo:block>1. region-start</fo:block></fo:inline-container>
Region of the left side where 'left' is written. The length from the left edge of the paper to the left edge of the region-start can be specified by the margin-left property. The width of region-start can be specified by the extent property.
</fo:block>
<fo:block></fo:block>
<fo:block><fo:inline-container font-weight="bold"><fo:block>2. region-end</fo:block> </fo:inline-container>
Region of the right side where 'right' is written. The length from the right edge of the paper to the right edge of the region-end can be specified by the margin-end property. The width of region-end can be specified by the extent property.
</fo:block>
<fo:block></fo:block>
<fo:block><fo:inline-container font-weight="bold"><fo:block>3. region-before </fo:block></fo:inline-container>
 The upper region where the AntennaHouse logo is placed. The length from the top edge of the paper to the top edge of the region-before can be specified by the margin-top property. The depth ofregion-before can be specified by the extent property. This will be the most commonly used to create headers.
</fo:block>
<fo:block></fo:block>
<fo:block><fo:inline-container font-weight="bold"><fo:block>4. region-after</fo:block></fo:inline-container>
 The lower region where 'bottom' is placed. The length from the bottom edge of the paper to the bottom edge of the region-before can be specified by the margin-bottom property. The depth of region-after can be specified by the extent property. This will be the most commonly used to create footers.
</fo:block>
<fo:block></fo:block>
<fo:block><fo:inline-container font-weight="bold"><fo:block>5. region-body</fo:block></fo:inline-container>
 The middle region of the page where the text is placed.
</fo:block>
<fo:block></fo:block>
<fo:block>

As the example shows, it is possible to specify a boader line in each region with different types and weight of the line.
</fo:block>
</fo:block>
</fo:flow>
</fo:page-sequence>
</fo:root>
