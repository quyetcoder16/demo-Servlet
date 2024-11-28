$(document).ready(function () {

	$("#btn-add-role").click(function (e) {

        e.preventDefault();
        var name = $("#role-add-name").val();
        var desc = $("#role-add-desc").val();
        $.ajax({
            method: "POST",
            url: "http://localhost:8080/cm/api/roles/add",
            data: { name: name, desc: desc }
        })
            .done(function (data) {
                alert("thêm Thành công!")
            });
    })
	
    $(".btn-xoa").click(function () {
        var id = $(this).attr("id-role");
        var row = $(this).closest("tr");
        $.ajax({
            method: "POST",
            url: "http://localhost:8080/cm/api/roles",
            data: { id: id }
        })
            .done(function (data) {
                if (data?.isSuccess) {
                    row.remove();
                } else {
                    alert("xoa that bai!" + data)
                }
            });
    })


    


})