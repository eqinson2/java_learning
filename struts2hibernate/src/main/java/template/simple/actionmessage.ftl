<#if (actionMessages?exists && actionMessages?size > 0)>
	<font color="red">
		<#list actionMessages as message>
			<b>${message}</b>
		</#list>
	</font>
</#if>
