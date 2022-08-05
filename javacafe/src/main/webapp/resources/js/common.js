$(function() {

  // main카테고리 선택했을때 .on추가, 제거
  // 서브카테고리도 알아서 안보이게
  $(".mainc").click(function() {

    var mainCategory = $(this).text();

    if($(this).text() == "전체보기") {
      $(".product").removeClass("on");
      $(".product").addClass("on");

      $(".subc").removeClass("on");
    } else {
      $(".product").removeClass("on");
      $(`.product.${mainCategory}`).addClass("on");

      $(".subc").removeClass("on");
      $(".subc.sub-all").addClass("on");
      $(`.subc.${mainCategory}`).addClass("on");
    }

  });

  // 서브카테고리 선택시
  $(".subc").click(function() {
    var subCategory = $(this).children("p").text();
    console.log(subCategory);
    if ($(this).children("p").text() == "전체보기") {
      $(".product").removeClass("on");
      $(".product").addClass("on");
    } else {
      $(".product").removeClass("on");
      $(`.product.${subCategory}`).addClass("on");
    }

  });




});
