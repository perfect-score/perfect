function setField(id, value)
{
  $(id).val(value);
}

function activeTab(nav_link_id)
{
  $(nav_link_id).addClass('active').siblings().removeClass('active');
}

function selectSelector(id, value)
{
  $('#' + id + ' option[value="' + value + '"]').attr("selected",true);
}

function growl(icon, title, message)
{
	// https://kamranahmed.info/toast
	
	var bgColor = '#DC3545';
	var textColor = '#000000';
	
	$.toast({
	    heading: title,
	    text: message,
	    position: { top: '12px', right: '14px' },
		icon: icon,
	    loader: true,         // Loader enabled
	    loaderBg: '#000000',  // To change the loader background
	    stack: true,
	    showHideTransition: 'fade',
	    hideAfter: 5000,
	    bgColor: bgColor,
	    textColor: textColor,
	})
	
}

function resultPost(element)
{
  var formData = {
        leagueSeasonId : element.parentElement.cells[0].textContent,
        weekNo : element.parentElement.cells[1].textContent,
        gameNo : element.parentElement.cells[2].textContent,
        scoreHome : element.parentElement.cells[6].textContent,
        scoreAway : element.parentElement.cells[8].textContent,
  }

  $.ajax({
      url : element.baseURI + "/api/results/save",
      type: "POST",
      contentType : "application/json",
      data : JSON.stringify(formData),
      dataType : 'json',
      success: function(result)
      {
        if (result.status == "Success")
        {
          console.log("Success " + formData);
        }
        else
        {
          growl('error', "Error", "Home score incorrect." );
        }
        console.log(result);
      },
	  error : function(e)
	  {
	    console.log("ERROR: ", e);
	  }
  });
}
