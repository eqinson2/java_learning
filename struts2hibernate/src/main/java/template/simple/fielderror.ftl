<#if fieldErrors?exists><#t/>
<#assign eKeys = fieldErrors.keySet()><#t/>
<#assign eKeysSize = eKeys.size()><#t/>
<#assign doneStartUlTag=false><#t/>
<#assign doneEndUlTag=false><#t/>
<#assign haveMatchedErrorField=false><#t/>
<#if (fieldErrorFieldNames?size > 0) ><#t/>
	<#list fieldErrorFieldNames as fieldErrorFieldName><#t/>
		<#list eKeys as eKey><#t/>
		<#if (eKey = fieldErrorFieldName)><#t/>
			<#assign haveMatchedErrorField=true><#t/>
			<#assign eValue = fieldErrors[fieldErrorFieldName]><#t/>
			<#if (haveMatchedErrorField && (!doneStartUlTag))><#t/>
				<font color="red">
				<#assign doneStartUlTag=true><#t/>
			</#if><#t/>
			<#list eValue as eEachValue><#t/>
				<b>${eEachValue}</b>
			</#list><#t/>			
		</#if><#t/>
		</#list><#t/>
	</#list><#t/>
	<#if (haveMatchedErrorField && (!doneEndUlTag))><#t/>
		</font>
		<#assign doneEndUlTag=true><#t/>
	</#if><#t/>
<#else><#t/>	
	<#if (eKeysSize > 0)><#t/>
		<font color="red">
			<#list eKeys as eKey><#t/>
				<#assign eValue = fieldErrors[eKey]><#t/>
				<#list eValue as eEachValue><#t/>
					<b>${eEachValue}</b>
				</#list><#t/>
			</#list><#t/>
		</font>
	</#if><#t/>
</#if><#t/>
</#if><#t/>
