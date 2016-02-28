<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0" xmlns:ns="http://www.transcript.com">
	<xsl:template match="/">
		<xsl:element name="academic_qualification">
			<xsl:element name="university">
				<xsl:value-of select="/transcript/university/@name"></xsl:value-of>
			</xsl:element>
			<xsl:element name="degree">
				<xsl:value-of select="/transcript/degree"></xsl:value-of>
			</xsl:element>
			<xsl:element name="year">
				<xsl:value-of select="/transcript/year"></xsl:value-of>
			</xsl:element>
			<xsl:element name="gpa">
				<xsl:variable name="total_credits">
					<xsl:value-of select="sum(/transcript/courses/course/@credit)"></xsl:value-of>
				</xsl:variable>
				<xsl:variable name="total_grades" >
					<xsl:value-of select="sum(/transcript/courses/course/grade/@score)"></xsl:value-of>	
				</xsl:variable>

				<xsl:value-of select="$total_grades div $total_credits" />
			</xsl:element>
		</xsl:element>
	</xsl:template>
</xsl:stylesheet>