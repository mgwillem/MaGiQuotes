PrimeFaces.ajax.AjaxRequest = function(h, g, e) {
    if (g.onstart) {
        var b = g.onstart.call(this);
        if (b == false) {
            return
        }
    }
    var a = h, i = null;
    if (g.formId) {
        var c = jQuery(PrimeFaces.escapeClientId(g.formId)), i = c.serialize(), d = c.children("input[name='javax.faces.encodedURL']");
        if (d.length > 0) {
            a = d.val()
        }
    } else {
        i = PrimeFaces.VIEW_STATE + "=" + PrimeFaces.ajax.AjaxUtils.encodeViewState()
    }
    i = i + "&" + PrimeFaces.PARTIAL_REQUEST_PARAM + "=true";
    if (typeof g.source == "string") {
        i = i + "&" + PrimeFaces.PARTIAL_SOURCE_PARAM + "=" + g.source
    } else {
        i = i + "&" + PrimeFaces.PARTIAL_SOURCE_PARAM + "=" + g.source.id
    }
    if (g.process) {
        i = i + "&" + PrimeFaces.PARTIAL_PROCESS_PARAM + "=" + g.process
    }
    if (g.update) {
        i = i + "&" + PrimeFaces.PARTIAL_UPDATE_PARAM + "=" + g.update
    }
    if (g.event) {
        i = i + "&" + PrimeFaces.BEHAVIOR_EVENT_PARAM + "=" + g.event
    } else {
        i = i + "&" + g.source + "=" + g.source
    }
    if (e) {
        i = i + PrimeFaces.ajax.AjaxUtils.serialize(e)
    }
    var f = {url: a,type: "POST",cache: false,dataType: "xml",data: i,beforeSend: function(j) {
            j.setRequestHeader("Faces-Request", "partial/ajax")
        },success: function(l, j, m) {
            if (g.onsuccess) {
                var k = g.onsuccess.call(this, l, j, m);
                if (k === false) {
                    return
                }
            }
            PrimeFaces.ajax.AjaxResponse.call(this, l, j, m)
        },complete: function(k, j) {
            if (g.oncomplete) {
                g.oncomplete.call(this, k, j, this.args);
            }
            try {
                if (k.responseXML != undefined && k.responseXML != null && k.responseXML.documentElement != undefined && k.responseXML.documentElement != null) {
                    var xDoc = k.responseXML.documentElement, 
                        redirect = xDoc.getElementsByTagName("redirect");
                        
                    if (redirect.length > 0) {
                        window.location = redirect[0].attributes.getNamedItem("url").nodeValue;
                        return;
                    }
                }
            } catch (e) {

            }
            
            PrimeFaces.ajax.RequestManager.poll()
        }};
    f.global = g.global === false ? false : true;
    if (g.onerror) {
        f.error = g.onerror
    }
    if (g.async) {
        jQuery.ajax(f)
    } else {
        PrimeFaces.ajax.RequestManager.offer(f)
    }
};