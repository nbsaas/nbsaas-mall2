[#macro menu item]
     [#if item.childrens??]
				<li class="active"><a href="#" class="dropdown-toggle"> <i
					class="icon-edit"></i> <span class="menu-text"> ${item.name!""} </span> <b
					class="arrow icon-angle-down"></b>
			   </a>
	
				<ul class="submenu">
					[#list item.childrens as item]
				     [@menu item]
				     [/@menu]
				     [/#list]
				</ul>
        [#else]
			<li>
			<a href="#"> 
			<i class="icon-dashboard"></i> 
			<span class="menu-text"> ${item.name!""} </span>
			</a>
			</li>
		[/#if]
 
[/#macro]

	<ul class="nav nav-list">
	[#list menus as item]
     [@menu item]
     [/@menu]
     [/#list]
     </ul>
