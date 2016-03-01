<?xml version="1.0" encoding="UTF-8" ?>

<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format" xml:lang="en">
	<fo:layout-master-set>
		<fo:simple-page-master page-height="279mm" page-width="216mm" margin-top="10mm" margin-left="20mm" margin-right="20mm" margin-bottom="10mm" master-name="PageMaster">
			<fo:region-body border-style="none" border-width="thin" margin-top="20mm" margin-left="0mm" margin-right="0mm" margin-bottom="10mm"/>
			
			<fo:region-before border-style="none" border-width="thin" extent="15mm"/>
			<fo:region-after border-style="none" border-width="thin" extent="15mm"/>
		</fo:simple-page-master>
	</fo:layout-master-set>
	<fo:page-sequence initial-page-number="1" master-reference="PageMaster">
		<fo:static-content flow-name="xsl-region-before">
			<fo:block font-size="9pt">
				<fo:external-graphic src="url('img\antenna-en.png')" content-height="12mm"/>
				XSL FO Sample Copyright &#xA9; 2002-2005 Antenna House, Inc. All rights reserved.
			</fo:block>
		</fo:static-content>
		<fo:flow flow-name="xsl-region-body">
			<fo:block text-indent="1em" font-family="sans-serif" font-size="20pt" font-weight="bold" background-color="#EEEEEE" line-height="20mm">
				Character style settings</fo:block>
				<fo:block space-before="2em">Example of specifying an italic typeface, specifying a bold typeface.</fo:block><fo:block space-before="4em" font-family="sans-serif" line-height="10mm">
					<fo:block font-size="14pt">This is a <fo:inline font-weight="bold">bold </fo:inline>character.</fo:block>
					<fo:block font-size="14pt">This is an <fo:inline font-style="italic">italic </fo:inline>character.</fo:block>
					<fo:block font-size="14pt">This is a mixture of <fo:inline font-weight="bold" font-style="italic">bold and italic.</fo:inline></fo:block>
					<fo:block font-size="14pt">This is a  <fo:inline baseline-shift="super">superscript.</fo:inline></fo:block>
					<fo:block font-size="14pt">This is a <fo:inline baseline-shift="sub">subscript.</fo:inline></fo:block>
					<fo:block font-size="14pt">This is an  <fo:inline text-decoration="underline">underline.</fo:inline></fo:block>
					<fo:block font-size="14pt">This is an <fo:inline text-decoration="overline">overline.</fo:inline></fo:block>
					<fo:block font-size="14pt">This is a <fo:inline text-decoration="line-through">line-through.</fo:inline></fo:block>
					<fo:block font-size="14pt">This is an example of enclosing text with <fo:inline border-style="solid">solid</fo:inline> line.</fo:block>
					<fo:block font-size="14pt">This is an example of enclosing test with <fo:inline border-style="dotted">dots</fo:inline>.</fo:block>
					<fo:block font-size="14pt">This is an example of specifying <fo:inline background-color="yellow">yellow</fo:inline> for the background.</fo:block>
					<fo:block font-size="14pt">This is an example of specifying <fo:inline background-color="cyan">cyan</fo:inline> for the background.</fo:block>
					<fo:block font-size="14pt">As this example shows, you can   <fo:inline font-weight="bold" background-color="pink">modify </fo:inline><fo:inline font-weight="bold" background-color="lime" font-style="italic">various styles of the character</fo:inline> by specifying<fo:inline text-decoration="underline"> one style,</fo:inline> or by specifying <fo:inline font-weight="bold" background-color="#a0d0f0">mixed styles </fo:inline><fo:inline border-style="solid" font-weight="bold">flexibly</fo:inline>.</fo:block>
				</fo:block></fo:flow>
	</fo:page-sequence>
</fo:root>
