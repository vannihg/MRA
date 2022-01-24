<#include "header.ftl">

<b>Movie Overview</b><br><br>


<table class="movies">

	<tr>
		<th>Title</th><th>Director</th><th>Actors</th><th>Publishing Date</th><th>Average Rating</th>
	</tr>
    <#list movies as movie>
    <tr>
        <a href="/addRate?mid=${movie.mid}&action=addRate"><td>${movie.title}</td> <td>${movie.director}</td><td>${movie.actors}</td><td>${movie.publishingDate}</td><td>${movie.averageRate}</td></a>
    </tr>
    </#list>
</table>

<#include "footer.ftl">