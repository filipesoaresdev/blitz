if (window.CKEDITOR) {
    CKEDITOR.editorConfig = function(config) {
        var contextPath = $('#contextPath').val();
        console.log("contextpath: " + contextPath);

        config.toolbar = [
            {name: 'document', groups: ['mode', 'document', 'doctools'], items: ['NewPage', 'Preview', 'Print']},
            {name: 'clipboard', groups: ['clipboard', 'undo'], items: ['Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo']},
            {name: 'editing', groups: ['find', 'selection', 'spellchecker'], items: ['Find', 'Replace', '-', 'SelectAll', '-', 'Scayt']},
            {name: 'basicstyles', groups: ['basicstyles', 'cleanup'], items: ['Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', '-', 'RemoveFormat']},
            {name: 'paragraph', groups: ['list', 'indent', 'blocks', 'align', 'bidi'], items: ['NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote', '-', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock', '-', 'BidiLtr', 'BidiRtl', 'Language']},
            
            {name: 'links', items: ['Link', 'Unlink']},
            {name: 'insert', items: ['Image', 'Table', 'HorizontalRule', 'SpecialChar', 'Smiley']},
            {name: 'styles', items: ['Styles', 'Format', 'Font', 'FontSize']},
            {name: 'colors', items: ['TextColor', 'BGColor']},
            {name: 'tools', items: ['Maximize']}
        ];

    };
}