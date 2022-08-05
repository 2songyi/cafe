$(function() {

$(".mainselect").change(function() {
  var select = $(this).val();
  console.log(select);

  if ($(this).val() == "all") {
    $('.subselect').removeClass("show");
    $('.subselect').addClass("show");
  } else {
    $('.subselect').removeClass("show");
    $(`.subselect.${select}`).addClass("show");
  }

});

});
