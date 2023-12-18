<#import "blocks/template.ftlh" as t>
<@t.template user>
<h5>Редактирование пользователя ${user.getName()}</h5><hr>
    <form action="/avatar/create" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="productName">Название </label>
            <input type="text" required class="form-control"
                   id="productName" name="title">
        </div>
        <div class="form-group">
            <div class="input-group mb-3">
                <label class="input-group-text" for="ava1">Upload</label>
                <input type="file" class="form-control" name="ava1" id="ava1">
            </div>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

        <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
    </form>

</@t.template>

