function initIntroAnimations() {
    function e() {
        v ? ($(y).removeClass("trigger"), $("#intro_slide-desc").removeClass("trigger"), $("#intro_anim--cloud1").removeClass("trigger"), $("#intro_anim--cloud2").removeClass("trigger"), $("#intro_anim--grounds_holder").removeClass("trigger"), $("#intro_anim--ground1_holder").removeClass("trigger"), $("#intro_anim--surfer").removeClass("trigger"), $("#intro_anim--rocket").removeClass("trigger"), $("#intro_anim--mountains").removeClass("trigger"), $("#intro_anim--ground2_top").removeClass("trigger"), $("#intro_anim--ground2_holder").removeClass("trigger"), $("#intro_anim--skier").removeClass("trigger"), $("#intro_anim--tree1").removeClass("trigger"), $("#intro_anim--tree2").removeClass("trigger"), $("#intro_anim--school").removeClass("trigger"), $("#intro_anim--hotdog").removeClass("trigger"), $("#intro_anim--bus").removeClass("trigger"), $("#intro_anim--car").removeClass("trigger"), $("#intro_anim--sign").removeClass("trigger"), $("#intro_anim--golf").removeClass("trigger"), $("#intro_anim--house").removeClass("trigger"), $("#intro_anim--sun").removeClass("trigger"), $("#intro_anim--balloon").removeClass("trigger")) : ($(y).css({
            visibility: "hidden",
            opacity: 0
        }), $("#intro_slide-desc").css({
            visibility: "hidden",
            opacity: 0
        })), E.reset(), _.reset()
    }

    function t() {
    }

    function n() {
        v ? ($(w).removeClass("trigger"), $("#apps-start").removeClass("trigger"), $("#apps-desc").removeClass("trigger")) : ($(w).css({
            visibility: "hidden",
            opacity: 0
        }), $("#apps-start").css({
            visibility: "hidden",
            opacity: 0
        }), $("#apps-desc").css({
            visibility: "hidden",
            opacity: 0
        })), z.reset(), T.reset()
    }

    function o() {
        v ? ($(k).removeClass("trigger"), $("#awesome-desc").removeClass("trigger"), $("#awesome-be").removeClass("trigger"), $("#awesome-sun1").removeClass("trigger"), $("#awesome-sun2").removeClass("trigger")) : ($(k).css({
            visibility: "hidden",
            opacity: 0
        }), $("#awesome-be").css({
            visibility: "hidden",
            opacity: 0
        }), $("#awesome-desc").css({
            visibility: "hidden",
            opacity: 0
        }), $("#awesome-sun1").css({
            visibility: "hidden",
            opacity: 0
        }), $("#awesome-sun2").css({
            visibility: "hidden",
            opacity: 0
        })), A.reset(), j.reset()
    }

    function i() {
        $(x).removeClass("trigger"), S.reset()
    }

    function r() {
        $("#lookinside-hand--motion").removeClass("trigger_next trigger_prev"), $("#lookinside-hand--motion").fadeOut(0), $("#lookinside-hand--motion").fadeIn(0)
    }

    function a() {
        R.css({
            marginTop: "-66px"
        })
    }

    function s() {
        R.css({
            marginTop: "0px"
        })
    }

    function l(e) {
        s(), setTimeout(function() {
            var t = document.getElementById("lookinside-slides").children;
            v ? ($("#lookinside-slides").css({
                left: -(100 * e) + "%"
            }), R.css({
                top: "0%"
            }), W.css({
                top: "0%"
            }), Y.css({
                top: "-100%"
            }), $(t).removeClass("trigger"), $(t[e]).addClass("trigger")) : ($("#lookinside-slides").stop(!0).animate({
                left: -(100 * e) + "%"
            }, 1e3), R.stop(!0).animate({
                top: "0%"
            }, 1e3), W.stop(!0).animate({
                top: "0%"
            }, 1e3), Y.stop(!0).animate({
                top: "-100%"
            }, 1e3, "linear"), $(t).addClass("trigger")), P.removeClass("notebook_tab"), B.stop(!0).fadeIn(1e3), O.removeClass("active"), $("#lookinside_switch--mobile").addClass("active")
        }, v ? 500 : 0), u(I[2], H[2])
    }

    function u(e, t) {
        I.removeClass("active"), H.removeClass("active"), e || (e = I[$(t).index()]), t || (t = H[$(e).index()]), $(e).addClass("active"), $(t).addClass("active")
    }

    function c(e, t) {
        switch ((e || t).hash) {
            case "#nav_0":
            case "#nav_1":
            case "#nav_2":
            case "#nav_3":
            case "#nav_4":
                it.running = !1, rt.running = !1, clearTimeout(it.timeout), clearTimeout(rt.timeout), u(e, t)
        }
        switch ((e || t).hash) {
            case "#nav_0":
                it.goto(0);
                break;
            case "#nav_1":
                rt.goto(1);
                break;
            case "#nav_2":
                rt.goto(2);
                break;
            case "#nav_3":
                rt.goto(rt.actionsList.length - 2);
                break;
            case "#nav_4":
                rt.goto(rt.actionsList.length - 1)
        }
    }

    function d(e, t) {
        e.deltaY < 0 ? t.next(t) : t.prev(t)
    }

    function p(e, t) {
        clearTimeout(lt), ut = t.changedTouches[0].pageY, st = e, dt = !0, pt = !1, lt = setTimeout(function() {
            dt = !1, pt = !1
        }, 250)
    }

    function f(e, t) {
        clearTimeout(lt), dt && st === e && (t.preventDefault(), pt = !0)
    }

    function h(e, t) {
        ct = t.changedTouches[0].pageY, at.deltaY = ct - ut, st === e && pt && Math.abs(at.deltaY) > 50 && d(at, st), dt = !1, pt = !1
    }
    var m, g, v = isCSSFeatureSupported("animation") && isCSSFeatureSupported("transition"),
        y = document.getElementsByClassName("intro_text-letter"),
        b = document.getElementsByClassName("hotdog-text_letter"),
        w = document.getElementsByClassName("apps-text_letter"),
        k = document.getElementsByClassName("awesome-text_letter"),
        x = document.getElementsByClassName("circle-icon"),
        _ = new Sequence,
        C = new Sequence,
        T = new Sequence,
        j = new Sequence,
        S = new Sequence,
        E = new Sequence,
        N = new Sequence,
        z = new Sequence,
        A = new Sequence;
    if (y && y.length)
        for (m = 0, g = y.length; g > m; m++) _.tasks.push({
            wait: 50,
            task: function(e) {
                v ? $(y[e]).addClass("trigger") : ($(y[e]).css({
                    visibility: "visible"
                }), $(y[e]).animate({
                    opacity: 1
                }, 600, "linear"))
            }
        });
    if (b && b.length)
        for (m = 0, g = b.length; g > m; m++) C.tasks.push({
            wait: 50,
            task: function(e) {
                v ? $(b[e]).addClass("trigger") : ($(b[e]).css({
                    visibility: "visible"
                }), $(b[e]).animate({
                    opacity: 1
                }, 600, "linear"))
            }
        });
    if (w && w.length)
        for (m = 0, g = w.length; g > m; m++) T.tasks.push({
            wait: 50,
            task: function(e) {
                v ? $(w[e]).addClass("trigger") : ($(w[e]).css({
                    visibility: "visible"
                }), $(w[e]).animate({
                    opacity: 1
                }, 600, "linear"))
            }
        });
    if (k && k.length)
        for (m = 0, g = k.length; g > m; m++) j.tasks.push({
            wait: 50,
            task: function(e) {
                v ? $(k[e]).addClass("trigger") : ($(k[e]).css({
                    visibility: "visible"
                }), $(k[e]).animate({
                    opacity: 1
                }, 600, "linear"))
            }
        });
    if (x && x.length)
        for (m = 0, g = x.length; g > m; m++) S.tasks.push({
            wait: 0 == m ? 1e3 : 50,
            task: function(e) {
                v ? $(x[e]).addClass("trigger") : ($(x[e]).css({
                    visibility: "visible"
                }), $(x[e]).animate({
                    opacity: 1
                }, 600, "linear"))
            }
        });
    v ? (E.tasks.push({
        wait: 1e3,
        task: function() {
            $("#intro_anim--cloud1").addClass("trigger"), $("#intro_anim--cloud2").addClass("trigger")
        }
    }), E.tasks.push({
        wait: 300,
        task: function() {
            _.run(), $("#intro_anim--grounds_holder").addClass("trigger")
        }
    }), E.tasks.push({
        wait: 50,
        task: function() {
            $("#intro_anim--ground1_holder").addClass("trigger")
        }
    }), E.tasks.push({
        wait: 300,
        task: function() {
            $("#intro_anim--surfer").addClass("trigger"), $("#intro_anim--rocket").addClass("trigger")
        }
    }), E.tasks.push({
        wait: 150,
        task: function() {
            $("#intro_anim--mountains").addClass("trigger")
        }
    }), E.tasks.push({
        wait: 150,
        task: function() {
            $("#intro_anim--ground2_top").addClass("trigger"), $("#intro_anim--ground2_holder").addClass("trigger")
        }
    }), E.tasks.push({
        wait: 150,
        task: function() {
            $("#intro_anim--skier").addClass("trigger")
        }
    }), E.tasks.push({
        wait: 300,
        task: function() {
            $("#intro_anim--tree1").addClass("trigger"), $("#intro_anim--tree2").addClass("trigger"), $("#intro_anim--school").addClass("trigger"), $("#intro_anim--hotdog").addClass("trigger")
        }
    }), E.tasks.push({
        wait: 300,
        task: function() {
            $("#intro_anim--bus").addClass("trigger"), $("#intro_anim--car").addClass("trigger"), $("#intro_anim--sign").addClass("trigger"), $("#intro_anim--golf").addClass("trigger"), $("#intro_anim--house").addClass("trigger")
        }
    }), E.tasks.push({
        wait: 100,
        task: function() {
            $("#intro_anim--sun").addClass("trigger"), $("#intro_anim--balloon").addClass("trigger")
        }
    }), E.tasks.push({
        wait: 100,
        task: function() {
            v ? $("#intro_slide-desc").addClass("trigger") : ($("#intro_slide-desc").css({
                visibility: "visible"
            }), $("#intro_slide-desc").animate({
                opacity: 1
            }, 1500))
        }
    })) : ($("#intro_anim--cloud1").addClass("trigger"), $("#intro_anim--cloud2").addClass("trigger"), $("#intro_anim--grounds_holder").addClass("trigger"), $("#intro_anim--ground1_holder").addClass("trigger"), $("#intro_anim--surfer").addClass("trigger"), $("#intro_anim--rocket").addClass("trigger"), $("#intro_anim--mountains").addClass("trigger"), $("#intro_anim--ground2_top").addClass("trigger"), $("#intro_anim--ground2_holder").addClass("trigger"), $("#intro_anim--skier").addClass("trigger"), $("#intro_anim--tree1").addClass("trigger"), $("#intro_anim--tree2").addClass("trigger"), $("#intro_anim--school").addClass("trigger"), $("#intro_anim--hotdog").addClass("trigger"), $("#intro_anim--bus").addClass("trigger"), $("#intro_anim--car").addClass("trigger"), $("#intro_anim--sign").addClass("trigger"), $("#intro_anim--golf").addClass("trigger"), $("#intro_anim--house").addClass("trigger"), $("#intro_anim--sun").addClass("trigger"), $("#intro_anim--balloon").addClass("trigger"), E.tasks.push({
        wait: 1e3,
        task: function() {
            _.run(), v ? $("#intro_slide-desc").addClass("trigger") : ($("#intro_slide-desc").css({
                visibility: "visible"
            }), $("#intro_slide-desc").animate({
                opacity: 1
            }, 1500))
        }
    })), N.tasks.push({
        wait: 1e3,
        task: function() {
            v ? $("#hotdog-dontbe").addClass("trigger") : ($("#hotdog-dontbe").css({
                visibility: "visible"
            }), $("#hotdog-dontbe").animate({
                opacity: 1
            }, 1500))
        }
    }), N.tasks.push({
        wait: 350,
        task: function() {
            C.run()
        }
    }), N.tasks.push({
        wait: 500,
        task: function() {
            v ? $("#hotdog-desc").addClass("trigger") : ($("#hotdog-desc").css({
                visibility: "visible"
            }), $("#hotdog-desc").animate({
                opacity: 1
            }, 1500))
        }
    }), N.tasks.push({
        wait: 200,
        task: function() {
            $("#hotdog-sign").addClass("trigger")
        }
    }), z.tasks.push({
        wait: 1e3,
        task: function() {
            v ? $("#apps-start").addClass("trigger") : ($("#apps-start").css({
                visibility: "visible"
            }), $("#apps-start").animate({
                opacity: 1
            }, 1500))
        }
    }), z.tasks.push({
        wait: 350,
        task: function() {
            T.run()
        }
    }), z.tasks.push({
        wait: 200,
        task: function() {
            v ? $("#apps-desc").addClass("trigger") : ($("#apps-desc").css({
                visibility: "visible"
            }), $("#apps-desc").animate({
                opacity: 1
            }, 1500))
        }
    }), A.tasks.push({
        wait: 1e3,
        task: function() {
            v ? $("#awesome-be").addClass("trigger") : ($("#awesome-be").css({
                visibility: "visible"
            }), $("#awesome-be").animate({
                opacity: 1
            }, 1500))
        }
    }), A.tasks.push({
        wait: 350,
        task: function() {
            j.run()
        }
    }), A.tasks.push({
        wait: 200,
        task: function() {
            v ? $("#awesome-desc").addClass("trigger") : ($("#awesome-desc").css({
                visibility: "visible"
            }), $("#awesome-desc").animate({
                opacity: 1
            }, 1500))
        }
    }), A.tasks.push({
        wait: 50,
        task: function() {
            v ? $("#awesome-sun1").addClass("trigger") : ($("#awesome-sun1").css({
                visibility: "visible"
            }), $("#awesome-sun1").animate({
                opacity: 1
            }, 1e3))
        }
    }), A.tasks.push({
        wait: 50,
        task: function() {
            v ? $("#awesome-sun2").addClass("trigger") : ($("#awesome-sun2").css({
                visibility: "visible"
            }), $("#awesome-sun2").animate({
                opacity: 1
            }, 1e3))
        }
    });
    var L = function() {
        var e = document.getElementById("intro-anims_holder"),
            t = document.getElementById("intro-hotdog_holder"),
            n = document.getElementById("intro-apps_holder"),
            o = document.getElementById("intro-awesome_holder"),
            i = document.getElementById("intro_text--be"),
            r = document.getElementById("intro_text--visionare"),
            a = document.getElementById("hotdog-dontbe"),
            s = document.getElementById("hotdog-loser"),
            l = document.getElementById("apps-start"),
            u = document.getElementById("apps-apps"),
            c = document.getElementById("awesome-be"),
            d = document.getElementById("awesome-awesome");
        return function() {
            i.style.fontSize = e.scrollWidth / 10.2 + "px", r.style.fontSize = e.scrollWidth / 7.53 + "px", a.style.fontSize = t.scrollWidth / 15.7 + "px", s.style.fontSize = t.scrollWidth / 6.56 + "px", l.style.fontSize = n.scrollWidth / 21 + "px", u.style.fontSize = n.scrollWidth / 8.42 + "px", c.style.fontSize = o.scrollWidth / 10.65 + "px", d.style.fontSize = o.scrollWidth / 7 + "px"
        }
    }();
    window.onresize = L, L();
    var D = !1,
        M = !1,
        I = $(".menu_link", "#sidenav_menu"),
        H = $(".timeline-point", "#timeline"),
        P = $("#lookinside"),
        O = $("#lookinside_switch").children(),
        B = $("#lookinside_cols"),
        F = ($("#lookinside_desktop"), $("#section_slides-holder")),
        q = $("#section_slides"),
        R = $("#intro-skip"),
        W = $("#section_views-holder"),
        Y = $("#section_views"),
        X = new Action;
    X.enterAction = function() {
        s(), e(), E.run(), v ? (F.css({
            backgroundColor: "#a8cbd5"
        }), q.css({
            top: "0%"
        }), R.css({
            top: "100%"
        }), W.css({
            top: "100%"
        })) : (F.stop(!0).animate({
            backgroundColor: "#a8cbd5"
        }, 1e3, "linear"), q.stop(!0).animate({
            top: "0%"
        }, 1e3), R.stop(!0).animate({
            top: "100%"
        }, 1e3), W.stop(!0).animate({
            top: "100%"
        }, 1e3)), u(I[0], H[0])
    }, X.afterAction = function() {
        a()
    }, X.length = v ? 4e3 : 1e3;
    var V = new Action;
    V.enterAction = function() {
        s(), t(), N.run(), v ? (F.css({
            backgroundColor: "#ee7e72"
        }), q.css({
            top: "-100%"
        }), R.css({
            top: "100%"
        }), W.css({
            top: "100%"
        })) : (F.stop(!0).animate({
            backgroundColor: "#ee7e72"
        }, 1e3, "linear"), q.stop(!0).animate({
            top: "-100%"
        }, 1e3), R.stop(!0).animate({
            top: "100%"
        }, 1e3), W.stop(!0).animate({
            top: "100%"
        }, 1e3)), u(I[0], H[0])
    }, V.afterAction = function() {
        a(), e(), n()
    }, V.length = 3e3;
    var U = new Action;
    U.enterAction = function() {
        s(), n(), z.run(), v ? (F.css({
            backgroundColor: "#e4be6c"
        }), q.css({
            top: "-200%"
        }), R.css({
            top: "100%"
        }), W.css({
            top: "100%"
        })) : (F.stop(!0).animate({
            backgroundColor: "#e4be6c"
        }, 1e3, "linear"), q.stop(!0).animate({
            top: "-200%"
        }, 1e3), R.stop(!0).animate({
            top: "100%"
        }, 1e3), W.stop(!0).animate({
            top: "100%"
        }, 1e3)), u(I[0], H[0])
    }, U.afterAction = function() {
        a(), t(), o()
    }, U.length = 2500;
    var J = new Action;
    J.enterAction = function(e, t) {
        s(), o(), A.run(), t > e && (v ? (F.css({
            backgroundColor: "#9c91bf"
        }), q.css({
            top: "-300%"
        })) : (F.stop(!0).animate({
            backgroundColor: "#9c91bf"
        }, 1e3, "linear"), q.stop(!0).animate({
            top: "-300%"
        }, 1e3))), v ? (R.css({
            top: "100%"
        }), W.css({
            top: "100%"
        })) : (R.stop(!0).animate({
            top: "100%"
        }, 1e3), W.stop(!0).animate({
            top: "100%"
        }, 1e3)), u(I[0], H[0])
    }, J.afterAction = function() {
        a(), n()
    }, J.length = 2500;
    var Q = new Action;
    Q.enterAction = function() {
        v ? (R.css({
            top: "0%"
        }), W.css({
            top: "0%"
        })) : (R.stop(!0).animate({
            top: "0%"
        }, 1e3), W.stop(!0).animate({
            top: "0%"
        }, 1e3)), rt.goto(1)
    }, Q.afterAction = function() {
        a()
    }, Q.length = 1e3;
    var K = new Action;
    K.enterAction = function() {
        v ? (R.css({
            top: "100%"
        }), W.css({
            top: "100%"
        })) : (R.stop(!0).animate({
            top: "100%"
        }, 1e3), W.stop(!0).animate({
            top: "100%"
        }, 1e3)), D ? it.goto(it.current) : it.goto(it.actionsList.length - 2), D = !1
    }, K.afterAction = function() {
        a()
    }, K.length = 1e3;
    var G = new Action;
    G.enterAction = function(e, t) {
        s(), e > t && (v ? Y.css({
            top: "0%"
        }) : Y.stop(!0).animate({
            top: "0%"
        }, 1e3, "linear")), v ? (R.css({
            top: "0%"
        }), W.css({
            top: "0%"
        })) : (R.stop(!0).animate({
            top: "0%"
        }, 1e3), W.stop(!0).animate({
            top: "0%"
        }, 1e3)), u(I[1], H[1])
    }, G.afterAction = function() {
        a()
    }, G.length = 1500;
    var Z = new Action;
    Z.enterAction = function(e, t) {
        r(), l(0), e > t && !M && $("#lookinside-hand--motion").addClass("trigger_prev"), M = !1
    }, Z.afterAction = function() {
        a()
    }, Z.length = 2e3;
    var et = new Action;
    et.enterAction = function(e, t) {
        r(), l(1), $("#lookinside-hand--motion").addClass(e > t && !M ? "trigger_prev" : "trigger_next"), M = !1
    }, et.afterAction = function() {
        a()
    }, et.length = 2e3;
    var tt = new Action;
    tt.enterAction = function(e, t) {
        r(), l(2), t > e && !M && $("#lookinside-hand--motion").addClass("trigger_next"), M = !1
    }, tt.afterAction = function() {
        a()
    }, tt.length = 2e3;
    var nt = new Action;
    nt.enterAction = function() {
        s(), i(), S.run(), v ? (R.css({
            top: "0%"
        }), W.css({
            top: "0%"
        }), Y.css({
            top: "-200%"
        })) : (R.stop(!0).animate({
            top: "0%"
        }, 1e3), W.stop(!0).animate({
            top: "0%"
        }, 1e3), Y.stop(!0).animate({
            top: "-200%"
        }, 1e3, "linear")), u(I[3], H[3])
    }, nt.afterAction = a, nt.length = 2e3;
    var ot = new Action;
    ot.enterAction = function() {
        s(), v ? (R.css({
            top: "0%"
        }), W.css({
            top: "0%"
        }), Y.css({
            top: "-300%"
        })) : (R.stop(!0).animate({
            top: "0%"
        }, 1e3), W.stop(!0).animate({
            top: "0%"
        }, 1e3), Y.stop(!0).animate({
            top: "-300%"
        }, 1e3, "linear")), u(I[4], H[4])
    }, ot.afterAction = a, ot.length = 2e3;
    var it = new Actions;
    it.add(X), it.add(V), it.add(U), it.add(J), it.add(Q);
    var rt = new Actions;
    rt.add(K), rt.add(G), rt.add(Z), rt.add(et), rt.add(tt), rt.add(nt), rt.add(ot), $("#intro-skip").click(function() {
        it.running || (Q.enterAction(-1, 0), D = !0)
    }), I.click(function(e) {
        e.preventDefault(), c(this, null)
    }), H.click(function(e) {
        e.preventDefault(), c(null, this)
    }), O.click(function() {
        M = !0, -1 == this.id.indexOf("mobile") ? rt.goto(rt.actionsList.length - 3) : rt.goto(2)
    }), it.goto(0);
    var at = {
        deltaY: 0
    };
    if (F.mousewheel(function(e) {
            e.stopPropagation(), it.running || d(e, it)
        }), W.mousewheel(function(e) {
            e.stopPropagation(), rt.running || d(e, rt)
        }), $body.keydown(function(e) {
            var t = +(R[0].style.top || "0%").replace("%", ""),
                n = t > 0 ? it : rt;
            return at.deltaY = 0, 38 == e.keyCode && (at.deltaY = 1), 40 == e.keyCode && (at.deltaY = -1), 0 != at.deltaY ? (d(at, n), !1) : void 0
        }), Device.isTouchscreen && !Device.isMobile) {
        var st, lt, ut = 0,
            ct = 0,
            dt = !1,
            pt = !1;
        F[0].addEventListener("touchcancel", function(e) {
            h(it, e)
        }), F[0].addEventListener("touchstart", function(e) {
            p(it, e)
        }), F[0].addEventListener("touchmove", function(e) {
            f(it, e)
        }), F[0].addEventListener("touchend", function(e) {
            h(it, e)
        }), W[0].addEventListener("touchcancel", function(e) {
            h(rt, e)
        }), W[0].addEventListener("touchstart", function(e) {
            p(rt, e)
        }), W[0].addEventListener("touchmove", function(e) {
            f(rt, e)
        }), W[0].addEventListener("touchend", function(e) {
            h(rt, e)
        })
    }
}

function resizeSlides(e) {
    width = $circles.width(), $body.width() > $body.height() ? (e.maxSlide = Math.round(count / 2), $circleItems.css({
        maxWidth: width / 2
    })) : (e.maxSlide = count, $circleItems.css({
        maxWidth: width
    })), $circlesSlides.css({
        width: width * e.maxSlide
    }), $circlesPoints.html("");
    for (var t = 0; t < e.maxSlide; t++) $circlesPoint.clone().appendTo($circlesPoints);
    changedSlides(e), e.maxSlide = e.maxSlide > 0 ? e.maxSlide - 1 : 0
}

function changedSlides(e) {
    var t = $circlesPoints.children().removeClass("active");
    $(t[e.curSlide]).addClass("active")
}
var I18n = I18n || {};
I18n.defaultLocale = "en", I18n.fallbacks = !1, I18n.defaultSeparator = ".", I18n.locale = null, I18n.PLACEHOLDER = /(?:\{\{|%\{)(.*?)(?:\}\}?)/gm, I18n.isValidNode = function(e, t, n) {
    return null !== e[t] && e[t] !== n
}, I18n.lookup = function(e, t) {
    var n, t = t || {},
        o = e,
        i = this.prepareOptions(I18n.translations),
        r = i[t.locale || I18n.currentLocale()],
        t = this.prepareOptions(t);
    if (r) {
        for ("object" == typeof e && (e = e.join(this.defaultSeparator)), t.scope && (e = t.scope.toString() + this.defaultSeparator + e), e = e.split(this.defaultSeparator); e.length > 0;)
            if (n = e.shift(), r = r[n], !r) {
                I18n.fallbacks && !t.fallback && (r = I18n.lookup(o, this.prepareOptions({
                    locale: I18n.defaultLocale,
                    fallback: !0
                }, t)));
                break
            }
        return !r && this.isValidNode(t, "defaultValue") && (r = t.defaultValue), r
    }
}, I18n.prepareOptions = function() {
    for (var e, t = {}, n = arguments.length, o = 0; n > o; o++)
        if (e = arguments[o])
            for (var i in e) this.isValidNode(t, i) || (t[i] = e[i]);
    return t
}, I18n.interpolate = function(e, t) {
    t = this.prepareOptions(t);
    var n, o, i, r = e.match(this.PLACEHOLDER);
    if (!r) return e;
    for (var a = 0; n = r[a]; a++) i = n.replace(this.PLACEHOLDER, "$1"), o = t[i], this.isValidNode(t, i) || (o = "[missing " + n + " value]"), regex = new RegExp(n.replace(/\{/gm, "\\{").replace(/\}/gm, "\\}")), e = e.replace(regex, o);
    return e
}, I18n.translate = function(e, t) {
    t = this.prepareOptions(t);
    var n = this.lookup(e, t);
    try {
        return "object" == typeof n ? "number" == typeof t.count ? this.pluralize(t.count, e, t) : n : this.interpolate(n, t)
    } catch (o) {
        return this.missingTranslation(e)
    }
}, I18n.localize = function(e, t) {
    switch (e) {
        case "currency":
            return this.toCurrency(t);
        case "number":
            return e = this.lookup("number.format"), this.toNumber(t, e);
        case "percentage":
            return this.toPercentage(t);
        default:
            return e.match(/^(date|time)/) ? this.toTime(e, t) : t.toString()
    }
}, I18n.parseDate = function(e) {
    var t, n;
    if ("object" == typeof e) return e;
    if (t = e.toString().match(/(\d{4})-(\d{2})-(\d{2})(?:[ T](\d{2}):(\d{2}):(\d{2}))?(Z|\+0000)?/)) {
        for (var o = 1; 6 >= o; o++) t[o] = parseInt(t[o], 10) || 0;
        t[2] -= 1, n = t[7] ? new Date(Date.UTC(t[1], t[2], t[3], t[4], t[5], t[6])) : new Date(t[1], t[2], t[3], t[4], t[5], t[6])
    } else "number" == typeof e ? (n = new Date, n.setTime(e)) : e.match(/\d+ \d+:\d+:\d+ [+-]\d+ \d+/) ? (n = new Date, n.setTime(Date.parse(e))) : (n = new Date, n.setTime(Date.parse(e)));
    return n
}, I18n.toTime = function(e, t) {
    var n = this.parseDate(t),
        o = this.lookup(e);
    return n.toString().match(/invalid/i) ? n.toString() : o ? this.strftime(n, o) : n.toString()
}, I18n.strftime = function(e, t) {
    var n = this.lookup("date");
    if (!n) return e.toString();
    n.meridian = n.meridian || ["AM", "PM"];
    var o = e.getDay(),
        i = e.getDate(),
        r = e.getFullYear(),
        a = e.getMonth() + 1,
        s = e.getHours(),
        l = s,
        u = s > 11 ? 1 : 0,
        c = e.getSeconds(),
        d = e.getMinutes(),
        p = e.getTimezoneOffset(),
        f = Math.floor(Math.abs(p / 60)),
        h = Math.abs(p) - 60 * f,
        m = (p > 0 ? "-" : "+") + (f.toString().length < 2 ? "0" + f : f) + (h.toString().length < 2 ? "0" + h : h);
    l > 12 ? l -= 12 : 0 === l && (l = 12);
    var g = function(e) {
            var t = "0" + e.toString();
            return t.substr(t.length - 2)
        },
        v = t;
    return v = v.replace("%a", n.abbr_day_names[o]), v = v.replace("%A", n.day_names[o]), v = v.replace("%b", n.abbr_month_names[a]), v = v.replace("%B", n.month_names[a]), v = v.replace("%d", g(i)), v = v.replace("%e", i), v = v.replace("%-d", i), v = v.replace("%H", g(s)), v = v.replace("%-H", s), v = v.replace("%I", g(l)), v = v.replace("%-I", l), v = v.replace("%m", g(a)), v = v.replace("%-m", a), v = v.replace("%M", g(d)), v = v.replace("%-M", d), v = v.replace("%p", n.meridian[u]), v = v.replace("%S", g(c)), v = v.replace("%-S", c), v = v.replace("%w", o), v = v.replace("%y", g(r)), v = v.replace("%-y", g(r).replace(/^0+/, "")), v = v.replace("%Y", r), v = v.replace("%z", m)
}, I18n.toNumber = function(e, t) {
    t = this.prepareOptions(t, this.lookup("number.format"), {
        precision: 3,
        separator: ".",
        delimiter: ",",
        strip_insignificant_zeros: !1
    });
    var n, o, i = 0 > e,
        r = Math.abs(e).toFixed(t.precision).toString(),
        a = r.split("."),
        s = [];
    for (e = a[0], n = a[1]; e.length > 0;) s.unshift(e.substr(Math.max(0, e.length - 3), 3)), e = e.substr(0, e.length - 3);
    if (o = s.join(t.delimiter), t.precision > 0 && (o += t.separator + a[1]), i && (o = "-" + o), t.strip_insignificant_zeros) {
        var l = {
            separator: new RegExp(t.separator.replace(/\./, "\\.") + "$"),
            zeros: /0+$/
        };
        o = o.replace(l.zeros, "").replace(l.separator, "")
    }
    return o
}, I18n.toCurrency = function(e, t) {
    return t = this.prepareOptions(t, this.lookup("number.currency.format"), this.lookup("number.format"), {
        unit: "$",
        precision: 2,
        format: "%u%n",
        delimiter: ",",
        separator: "."
    }), e = this.toNumber(e, t), e = t.format.replace("%u", t.unit).replace("%n", e)
}, I18n.toHumanSize = function(e, t) {
    for (var n, o, i = 1024, r = e, a = 0; r >= i && 4 > a;) r /= i, a += 1;
    return 0 === a ? (n = this.t("number.human.storage_units.units.byte", {
        count: r
    }), o = 0) : (n = this.t("number.human.storage_units.units." + [null, "kb", "mb", "gb", "tb"][a]), o = r - Math.floor(r) === 0 ? 0 : 1), t = this.prepareOptions(t, {
        precision: o,
        format: "%n%u",
        delimiter: ""
    }), e = this.toNumber(r, t), e = t.format.replace("%u", n).replace("%n", e)
}, I18n.toPercentage = function(e, t) {
    return t = this.prepareOptions(t, this.lookup("number.percentage.format"), this.lookup("number.format"), {
        precision: 3,
        separator: ".",
        delimiter: ""
    }), e = this.toNumber(e, t), e + "%"
}, I18n.pluralize = function(e, t, n) {
    var o;
    try {
        o = this.lookup(t, n)
    } catch (i) {}
    if (!o) return this.missingTranslation(t);
    var r;
    switch (n = this.prepareOptions(n), n.count = e.toString(), Math.abs(e)) {
        case 0:
            r = this.isValidNode(o, "zero") ? o.zero : this.isValidNode(o, "none") ? o.none : this.isValidNode(o, "other") ? o.other : this.missingTranslation(t, "zero");
            break;
        case 1:
            r = this.isValidNode(o, "one") ? o.one : this.missingTranslation(t, "one");
            break;
        default:
            r = this.isValidNode(o, "other") ? o.other : this.missingTranslation(t, "other")
    }
    return this.interpolate(r, n)
}, I18n.missingTranslation = function() {
    for (var e = '[missing "' + this.currentLocale(), t = arguments.length, n = 0; t > n; n++) e += "." + arguments[n];
    return e += '" translation]'
}, I18n.currentLocale = function() {
    return I18n.locale || I18n.defaultLocale
}, I18n.t = I18n.translate, I18n.l = I18n.localize, I18n.p = I18n.pluralize;
var I18n = I18n || {};
I18n.translations = {
    en: {
        date: {
            formats: {
                "default": "%d/%m/%Y",
                "short": "%b %d",
                "long": "%B %d, %Y"
            },
            day_names: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
            abbr_day_names: ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"],
            month_names: [null, "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
            abbr_month_names: [null, "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
            order: ["year", "month", "day"]
        },
        time: {
            formats: {
                "default": "%d/%m/%Y %H:%M",
                "short": "%d %b %H:%M",
                "long": "%B %d, %Y %H:%M"
            },
            am: "am",
            pm: "pm"
        },
        support: {
            array: {
                words_connector: ", ",
                two_words_connector: " and ",
                last_word_connector: ", and "
            }
        },
        number: {
            format: {
                separator: ".",
                delimiter: ",",
                precision: 3,
                significant: !1,
                strip_insignificant_zeros: !1
            },
            currency: {
                format: {
                    format: "%u%n",
                    unit: "$",
                    separator: ".",
                    delimiter: ",",
                    precision: 2,
                    significant: !1,
                    strip_insignificant_zeros: !1
                }
            },
            percentage: {
                format: {
                    delimiter: "",
                    format: "%n%"
                }
            },
            precision: {
                format: {
                    delimiter: ""
                }
            },
            human: {
                format: {
                    delimiter: "",
                    precision: 3,
                    significant: !0,
                    strip_insignificant_zeros: !0
                },
                storage_units: {
                    format: "%n %u",
                    units: {
                        "byte": {
                            one: "Byte",
                            other: "Bytes"
                        },
                        kb: "KB",
                        mb: "MB",
                        gb: "GB",
                        tb: "TB"
                    }
                },
                decimal_units: {
                    format: "%n %u",
                    units: {
                        unit: "",
                        thousand: "Thousand",
                        million: "Million",
                        billion: "Billion",
                        trillion: "Trillion",
                        quadrillion: "Quadrillion"
                    }
                }
            }
        },
        errors: {
            format: "%{attribute} %{message}",
            messages: {
                inclusion: "is not included in the list",
                exclusion: "is reserved",
                invalid: "is invalid",
                confirmation: "doesn't match %{attribute}",
                accepted: "must be accepted",
                empty: "can't be empty",
                blank: "can't be blank",
                present: "must be blank",
                too_long: "is too long (maximum is %{count} characters)",
                too_short: "is too short (minimum is %{count} characters)",
                wrong_length: "is the wrong length (should be %{count} characters)",
                not_a_number: "is not a number",
                not_an_integer: "must be an integer",
                greater_than: "must be greater than %{count}",
                greater_than_or_equal_to: "must be greater than or equal to %{count}",
                equal_to: "must be equal to %{count}",
                less_than: "must be less than %{count}",
                less_than_or_equal_to: "must be less than or equal to %{count}",
                other_than: "must be other than %{count}",
                odd: "must be odd",
                even: "must be even",
                taken: "has already been taken",
                in_between: "must be in between %{min} and %{max}",
                spoofed_media_type: "has an extension that does not match its contents",
                already_confirmed: "was already confirmed, please try signing in",
                confirmation_period_expired: "needs to be confirmed within %{period}, please request a new one",
                expired: "has expired, please request a new one",
                not_found: "not found",
                not_locked: "was not locked",
                not_saved: {
                    one: "1 error prohibited this %{resource} from being saved:",
                    other: "%{count} errors prohibited this %{resource} from being saved:"
                }
            }
        },
        activerecord: {
            errors: {
                messages: {
                    record_invalid: "Validation failed: %{errors}",
                    restrict_dependent_destroy: {
                        one: "Cannot delete record because a dependent %{record} exists",
                        many: "Cannot delete record because dependent %{record} exist"
                    }
                }
            }
        },
        datetime: {
            distance_in_words: {
                half_a_minute: "half a minute",
                less_than_x_seconds: {
                    one: "less than 1 second",
                    other: "less than %{count} seconds"
                },
                x_seconds: {
                    one: "1 second",
                    other: "%{count} seconds"
                },
                less_than_x_minutes: {
                    one: "less than a minute",
                    other: "less than %{count} minutes"
                },
                x_minutes: {
                    one: "1 minute",
                    other: "%{count} minutes"
                },
                about_x_hours: {
                    one: "about 1 hour",
                    other: "about %{count} hours"
                },
                x_days: {
                    one: "1 day",
                    other: "%{count} days"
                },
                about_x_months: {
                    one: "about 1 month",
                    other: "about %{count} months"
                },
                x_months: {
                    one: "1 month",
                    other: "%{count} months"
                },
                about_x_years: {
                    one: "about 1 year",
                    other: "about %{count} years"
                },
                over_x_years: {
                    one: "over 1 year",
                    other: "over %{count} years"
                },
                almost_x_years: {
                    one: "almost 1 year",
                    other: "almost %{count} years"
                }
            },
            prompts: {
                year: "Year",
                month: "Month",
                day: "Day",
                hour: "Hour",
                minute: "Minute",
                second: "Seconds"
            }
        },
        helpers: {
            select: {
                prompt: "Please select"
            },
            submit: {
                create: "Create %{model}",
                update: "Update %{model}",
                submit: "Save %{model}"
            }
        },
        will_paginate: {
            previous_label: "&#8592; Previous",
            next_label: "Next &#8594;",
            page_gap: "&hellip;",
            page_entries_info: {
                single_page: {
                    zero: "No %{model} found",
                    one: "Displaying 1 %{model}",
                    other: "Displaying all %{count} %{model}"
                },
                single_page_html: {
                    zero: "No %{model} found",
                    one: "Displaying <b>1</b> %{model}",
                    other: "Displaying <b>all&nbsp;%{count}</b> %{model}"
                },
                multi_page: "Displaying %{model} %{from} - %{to} of %{count} in total",
                multi_page_html: "Displaying %{model} <b>%{from}&nbsp;-&nbsp;%{to}</b> of <b>%{count}</b> in total"
            }
        },
        devise: {
            confirmations: {
                confirmed: "Your account was successfully confirmed.",
                send_instructions: "You will receive an email with instructions about how to confirm your account in a few minutes.",
                send_paranoid_instructions: "If your email address exists in our database, you will receive an email with instructions about how to confirm your account in a few minutes."
            },
            failure: {
                already_authenticated: "You are already signed in.",
                inactive: "Your account is not activated yet.",
                invalid: "Invalid email or password.",
                locked: "Your account is locked.",
                last_attempt: "You have one more attempt before your account will be locked.",
                not_found_in_database: "Invalid email or password.",
                timeout: "Your session expired. Please sign in again to continue.",
                unauthenticated: "You need to sign in or sign up before continuing.",
                unconfirmed: "You have to confirm your account before continuing."
            },
            mailer: {
                confirmation_instructions: {
                    subject: "Confirmation instructions"
                },
                reset_password_instructions: {
                    subject: "Reset password instructions"
                },
                unlock_instructions: {
                    subject: "Unlock Instructions"
                }
            },
            omniauth_callbacks: {
                failure: 'Could not authenticate you from %{kind} because "%{reason}".',
                success: "Successfully authenticated from %{kind} account."
            },
            passwords: {
                no_token: "You can't access this page without coming from a password reset email. If you do come from a password reset email, please make sure you used the full URL provided.",
                send_instructions: "You will receive an email with instructions about how to reset your password in a few minutes.",
                send_paranoid_instructions: "If your email address exists in our database, you will receive a password recovery link at your email address in a few minutes.",
                updated: "Your password was changed successfully. You are now signed in.",
                updated_not_active: "Your password was changed successfully."
            },
            registrations: {
                destroyed: "Bye! Your account was successfully cancelled. We hope to see you again soon.",
                signed_up: "Welcome! You have signed up successfully.",
                signed_up_but_inactive: "You have signed up successfully. However, we could not sign you in because your account is not yet activated.",
                signed_up_but_locked: "You have signed up successfully. However, we could not sign you in because your account is locked.",
                signed_up_but_unconfirmed: "A message with a confirmation link has been sent to your email address. Please open the link to activate your account.",
                update_needs_confirmation: "You updated your account successfully, but we need to verify your new email address. Please check your email and click on the confirm link to finalize confirming your new email address.",
                updated: "You updated your account successfully."
            },
            sessions: {
                signed_in: "Signed in successfully.",
                signed_out: "Signed out successfully."
            },
            unlocks: {
                send_instructions: "You will receive an email with instructions about how to unlock your account in a few minutes.",
                send_paranoid_instructions: "If your account exists, you will receive an email with instructions about how to unlock it in a few minutes.",
                unlocked: "Your account has been unlocked successfully. Please sign in to continue."
            }
        },
        scripts: {
            sending: "Sending ...",
            successfully_sent: "Sent successfully. Thank you!",
            error: "There is an error please try again later."
        },
        microsite: {
            section_menu: {
                start: "Start now",
                about: "About Visionare",
                "interface": "Interface",
                features: "Features",
                stay_in_touch: "Stay in touch"
            },
            sign_links: {
                facebook: "Facebook",
                twitter: "Twitter"
            },
            download_links: {
                download: "Download",
                mobile_app: "mobile app"
            },
            section_slides: {
                intro_slide: {
                    anims: {
                        be: "be",
                        visionare: "visionare",
                        desc: "Establish your goals. Connect with people who share similar dreams. Learn from those who are already there."
                    },
                    hotdog: {
                        dont_be: "Don’t be a",
                        loser: "loser",
                        desc: "No complaining, no blaming others, no making excuses. It’s time to make the right decision!"
                    },
                    apps: {
                        start_using: "Start using our",
                        apps: "apps",
                        desc: "Set your goals; track your progress and learn from the example of others."
                    },
                    awesome: {
                        be: "be",
                        awesome: "awesome",
                        desc: "Reach up, reach high. Your dreams are waiting..."
                    },
                    desc: "Establish your goals. Connect with people who share similar dreams. Learn from those who are already there."
                }
            },
            intro_skip: {
                desc: "scroll or skip intro"
            },
            section_views: {
                iwantto: {
                    title: "I would like to",
                    content_left: "Most of us gradually grow out of the artist we were as a child. Circle “Art” is here to help make that inner artist shine again. There are so many creative ways to express yourself! Would you like to be a dancer or perhaps star in a famous show? Maybe you would like to brush up on your poetry skills, sculpture like Michelangelo, be able draw your friend like one of your French girls, design beautiful interiors or just do a spot of gardening?",
                    content_right: "Art is as diverse as a human life itself. There is a connection of passion and inspiration that flows through every artistry and craft. Life without art and joy would be pretty lame, let’s admit it. Even when you don’t feel like working your hands, you can always work your soul through admiring paintings or watching a good movie.",
                    watch_video: "Watch our video",
                    watch_video_desc: "{1,5 min. youtube.com}",
                    art: {
                        title: "art",
                        desc: "improve my art skills",
                        content_left: "Most of us gradually grow out of the artist we were as a child. Circle “Art” is here to help make that inner artist shine again. There are so many creative ways to express yourself! Would you like to be a dancer or perhaps star in a famous show? Maybe you would like to brush up on your poetry skills, sculpture like Michelangelo, be able draw your friend like one of your French girls, design beautiful interiors or just do a spot of gardening?",
                        content_right: "Art is as diverse as a human life itself. There is a connection of passion and inspiration that flows through every artistry and craft. Life without art and joy would be pretty lame, let’s admit it. Even when you don’t feel like working your hands, you can always work your soul through admiring paintings or watching a good movie."
                    },
                    career: {
                        title: "career",
                        desc: "broaden my career",
                        content_left: "Confucius’s quote - “Find a job you love and you will never have to work again” is true to the dot here. The “Career” circle isn’t only focused on advancing your career or getting you that pay rise, but more on finding that perfect job, the one where you’ll never have to “work again”. Though every job has its pros and cons, we try to give you an insight into more career paths than you could imagine.",
                        content_right: "Some of you dream of being a doctor; some might want to be an entrepreneur. Maybe you just want to learn to love the job you currently have or enhance skills which could lead to a promotion. Remember that you are in charge of what you do as a job. Embark on that journey to find that one job you’ll truly love. Career affects our whole lives and, in some ways, even defines our character. We should strive to get this one right!"
                    },
                    lifestyle: {
                        title: "lifestyle",
                        desc: "improve my lifestyle",
                        content_left: "Lifestyle is about the values important to us and the ideas through which we define ourselves. For us at Visionare, helping others to achieve their dreams is our lifestyle. Your lifestyle may derive from your beliefs or experience. Maybe you’re more inclined to charity work and volunteering. Even more prosaic causes are valid; you may find lifestyle in your fashion or in music that you like.",
                        content_right: "Circle “Lifestyle” should serve as a pallet of ideas which can inspire you to open yourself to new ways of thinking about life. Everybody can follow any lifestyle path they desire, you can identify yourself with a healthy lifestyle or that of rocking the night away. Lifestyle is after all a celebration of human diversity."
                    },
                    fancy: {
                        title: "fancy",
                        desc: "live fancy",
                        content_left: "If you are a dreamer and a lover of life, “fancy” is the right circle for you. Everything that makes us happy, every small or a big thing is as important as ever here. So sit down, relax and imagine all the great and fancy things that you desire in your life. It can be a fancy dress that you need for a dinner party; it can be a sports car that you have dreamed of since you were a teenager.",
                        content_right: "Maybe you just want a new set of beautiful pencils for your drawing class or maybe you want a 150 feet long yacht with a private beach. In other words, fancy is just about everything that makes us happy in our lives. Imagination is the only limit here. Don’t be afraid to dream big, but remember to enjoy the everyday little things as well."
                    },
                    fun: {
                        title: "fun",
                        desc: "have fun",
                        content_left: "By definition, fun is all about the enjoyment of life. Go out there, embark on exciting new adventures and learn new skills to brighten up your life, be it a little or a lot! Why not learn how to skateboard? How about learning the best magic tricks to pull out at parties?",
                        content_right: "It doesn’t matter whether you would like to sky dive, cliff dive or scuba dive, as long as you have fun doing it! We will support you and help you find other people with the same spirit of fun. Fun knows no boundaries, it can be found in the greatest of quests as in everyday life enjoyments, and it all just depends on your attitude!"
                    },
                    education: {
                        title: "education",
                        desc: "higher my education",
                        content_left: "Doesn´t matter if you study foreign languages, read about the fall of the Roman Empire or struggle with a Ph.D. in mathematics. In circle “Education”, scientists, researchers and teachers shall provide you with tips and tricks to make learning a lot easier; but no surprise, the hard work will still be up to you.",
                        content_right: "Remember there are plenty of ways one can be educated and school might not be the only place where you should be looking. There is no shame in not knowing; the shame lies in not finding out. No dream is inaccessible, be it learning to derivate, understanding the theory of relativity or just attending school every day!"
                    },
                    personality: {
                        title: "personality",
                        desc: "improve my personality",
                        content_left: "Personality is a circle where your inner beauty can flourish. Sometimes having material goals is just not enough and improving your character can prove just as valuable. Do you need help handling stress better and facing your problems with stride? Are you heading down the spiritual path trying to find your purpose in life?",
                        content_right: "Maybe you just want to be a better person and melt even the coldest hearts. Inner strength goes a long way when it comes to conquering further goals and dreams. If we want to make a real positive change in the world, where else to start but with ourselves? Together let’s kick our bad personal habits out and replace them with new and great ones."
                    },
                    relations: {
                        title: "relations",
                        desc: "have better relations",
                        content_left: "Building relations is not always easy. Luckily for you, sharing interesting ideas and advice is some of the many ways that could help you unravel at least some mysteries of this complicated world of emotions and relations. Would you like to make friends with your colleagues or improve the mood in your basketball team?",
                        content_right: "Is your mother always arguing with you about things you do not want to waste time with? Learn how to persuade her or just make her trust you a little more. Improving and building relations is the main idea of this circle. We would like to help you to get along even with someone whose character is not necessarily your cup of tea. No barriers are unbreakable!"
                    },
                    sports: {
                        title: "sports",
                        desc: "be better at sports",
                        content_left: "Do you want to learn how to ice-skate or be able to do 10 pull-ups? Do you need motivation to jog three times a week? Circle „Sports“ is full of guides, tips, and templates which will make you fitter than ever. Training should be rewarding, regular, but most of all it should be fun.",
                        content_right: "Arnold Schwarzenegger didn’t only strengthen himself through squats. Out with blaming the weather for not putting your trainers on. Your pocket coach will keep you going with an organised and personalised training plan."
                    },
                    travel: {
                        title: "travel",
                        desc: "travel more",
                        content_left: "A circle called „Travel“ contains all your dreams, goals, plans, wishes and even the most secret desires related to travelling. Start planning your road trip around Western Europe and don’t miss anything! Fancy paddling around Ibiza? Plan well enough and you might just spend the next summer wherever you want to.",
                        content_right: "An infinite number of landscapes, countries, environments and cultures offer limitless opportunities and it’s just up to you to know how much you’re willing to discover. Once you step onto the road, there’s no telling where you’ll be swept off to next!"
                    },
                    articles: {
                        by: "by",
                        read_more: "READ MORE"
                    }
                },
                lookinside: {
                    title: "Look inside",
                    subtitle: "Mobile",
                    dreams: {
                        title: "Dreams",
                        content: "Place where you can write down your dreams. Divide them into achiavable steps or use a premade template already divided into simple “to-do’s” by a person who achieved given goal."
                    },
                    timeline: {
                        title: "Timeline",
                        content: "Much like in other media, our timeline allows you to communicate with other users and share your experiences and progress."
                    },
                    magazine: {
                        title: "Magazine",
                        content: "Some of your goals may require a deeper knowledge of the area in which you want to improve yourself. That is why we proudly introduce our magazine filled with content that helps you achieve your dreams."
                    },
                    profile: {
                        title: "Profile",
                        content: "In your profile you will find your personal settings and tools that will help you connect with other users who share the same goals and dreams."
                    }
                },
                features: {
                    title: "Visionare Features",
                    subtitle: "Are you excited?",
                    personalized_content: {
                        title: "Personalized content",
                        content: "Choosing from the variety of circles such as art and career allows us to narrow down what’s important to you!"
                    },
                    dreams_list: {
                        title: "Easy to make Dream list",
                        content: "Establishing your goals has never been easier. All your dreams are accessible in the palm of your hand."
                    },
                    step_by_step: {
                        title: "Step by Step Templates",
                        content: "Templates are your very own personal guides to your dreams. Follow those that are already there and draw from their experience!"
                    },
                    magazine: {
                        title: "Enriching Magazine",
                        content: "Magazine is the ideal place to collect tools and knowledge to set you on the right path on your journey."
                    },
                    community: {
                        title: "Helping community",
                        content: "Keep track of your progress on your timeline and motivate your friends to improve."
                    },
                    suggestion: {
                        title: "Smart Friend Suggestion",
                        content: "People around us shape our character. Connect with those who share your goals and push on even further."
                    }
                },
                makeawish: {
                    title: "Make a wish",
                    subtitle: "Send us your dream",
                    desc: "We will try to find a person who already achieved it, so you can enjoy professional guidance in our application. Send us your dream here or to info@bevisionare.com.",
                    form: {
                        side_a: {
                            success: "Successfully send",
                            error: "Please enter valid e-mail address",
                            placeholder: "Enter your dream.",
                            button: "OK"
                        },
                        side_b: {
                            error: "Please enter your dream",
                            placeholder: "Enter your email.",
                            button: "SEND"
                        }
                    }
                }
            }
        },
        magazine: {
            section_menu: {
                back_to_microsite: "Back to microsite"
            }
        }
    },
    cs: {
        scripts: {
            sending: "Posílání ...",
            successfully_sent: "Úspěšně odesláno. Děkujeme!",
            error: "Někde se stala chyba. Skuste znovu."
        },
        microsite: {
            section_menu: {
                start: "Start",
                about: "Cíle visionare",
                "interface": "Představení",
                features: "Funkce",
                stay_in_touch: "Kontakt"
            },
            sign_links: {
                facebook: "Facebook",
                twitter: "Twitter"
            },
            download_links: {
                download: "Stáhnout",
                mobile_app: "mobilní app"
            },
            section_slides: {
                intro_slide: {
                    anims: {
                        be: "be",
                        visionare: "visionare",
                        desc: "Stanov si své cíle! Spoj se s lidmi, kteří sdílí tvé sny. Čerpej ze zkušeností ostatních."
                    },
                    hotdog: {
                        dont_be: "Nebuď",
                        loser: "loser",
                        desc: "Nestěžuj si, neobviňuj druhé, nevymlouvej se. Je čas na správné rozhodnutí!"
                    },
                    apps: {
                        start_using: "Použij naši",
                        apps: "appku",
                        desc: "Stanov si cíle, mapuj svůj pokrok a inspiruj se z příkladu ostatních."
                    },
                    awesome: {
                        be: "buď",
                        awesome: "světový",
                        desc: "Miř vysoko, miř daleko! Tvoje sny čekají…"
                    },
                    desc: "Stanovte si své cíle. Spojte se s lidmi, co sdílí vaše sny. Učte se od těch, co mají potřebné zkušenosti."
                }
            },
            intro_skip: {
                desc: "Scrolluj dolů"
            },
            section_views: {
                iwantto: {
                    title: "Chtěl bych",
                    content_left: "Vraťte se v čase zpátky a najděte v sobě kdysi zapomenutého umělce, kterým jste bývali ve školce. Keramická socha ježka, obrázek celého vesmíru nebo hlavní role v představení pro rodiče? Nebyl problém. Rozmanitost umění vám poskytuje množství způsobů a oblastí pro seberealizaci. Každý jednou začínal, tak je využijte i vy!",
                    content_right: "Umění vzbuzuje nadšení a vášeň a život bez něj by byl pustý jako saharská duna. Nezáleží na tom, jestli budete umění vytvářet nebo pouze obdivovat. Je jen na vás, zda si zamilujete film, malování nebo třeba tanec.",
                    watch_video: "Podívej se na naše video",
                    watch_video_desc: "{1,5 min. youtube.com}",
                    art: {
                        title: "art",
                        desc: "se věnovat umění",
                        content_left: "Vraťte se v čase zpátky a najděte v sobě kdysi zapomenutého umělce, kterým jste bývali ve školce. Keramická socha ježka, obrázek celého vesmíru nebo hlavní role v představení pro rodiče? Nebyl problém. Rozmanitost umění vám poskytuje množství způsobů a oblastí pro seberealizaci. Každý jednou začínal, tak je využijte i vy!",
                        content_right: "Umění vzbuzuje nadšení a vášeň a život bez něj by byl pustý jako saharská duna. Nezáleží na tom, jestli budete umění vytvářet nebo pouze obdivovat. Je jen na vás, zda si zamilujete film, malování nebo třeba tanec."
                    },
                    career: {
                        title: "career",
                        desc: "pracovně růst",
                        content_left: "Může být něco krásnějšího než dělat to, co vás baví, a zároveň vědět, že to má smysl? Jedním ze základů pro spokojený život je najít si práci, která vás naplňuje. Chcete se stát doktorem a pomáhat lidem? Nebo chcete rozjet vlastní byznys a vydělávat miliony? Možná jen hledáte nadšení, se kterým jste do práce nastupovali.",
                        content_right: "Nezapomínejte, že jste pány své situace! Vy určujete směr! Nebojte se změny a začněte hledat práci, která pro vás bude zábavou. V oblasti Kariéra může najít inspiraci, rozhodnutí je ale pořád jen na vás. Nežijte pro práci, pracujte pro život."
                    },
                    lifestyle: {
                        title: "lifestile",
                        desc: "zlepšit svůj životní styl",
                        content_left: "Osobní životní styl se zakládá na hodnotách, které pokládáme za důležité. Pro nás ve Visionare považujeme za klíčové pomáhat lidem k dosažení cílů. Vás mohou charakterizovat životní zkušenosti a přesvědčení, které jste doposud získali. Láká vás charitativní a dobrovolnická práce? Zakládáte si na své módě či oblíbené hudbě? Oblast Životní styl slouží jako paleta nápadů a inspirace k tomu otevřít se novým způsobům myšlení o životě.",
                        content_right: "Každý by měl zvolit styl jemu vlastní a oprostit se od soudů jiných. Někdo rád paří, jiný rád vaří. Životní styl je konec konců oslava lidské rozmanitosti."
                    },
                    fancy: {
                        title: "fancy",
                        desc: "žít na vysoké noze",
                        content_left: "Jestliže milujete život ve všech jeho barvách a odstínech, pak si zamilujete i oblast Radosti. Společně prozkoumáme vše krásné a rozmařilé, co nám dokáže vykouzlit úsměv na rtech. Chcete si pořídit nablýskaný sporťák? Rády byste okouzlily na večerní koktejlové party v oslnivých šatech na míru? Nebo vám k radosti stačí upletený věnec z pampelišek? Fantazii se meze nekladou.",
                        content_right: "Radosti jsou malé i velké. Důležité je, aby vás učinily šťastnými, ať už na okamžik, nebo na celý život. Nebojte se mít velké sny, zároveň ale nezapomínejte si užívat i každodenní maličkosti."
                    },
                    fun: {
                        title: "fun",
                        desc: "se bavit",
                        content_left: "Zábava je umění radovat se ze života a přijímat každodenní strasti s úsměvem. Vydejte se za dobrodružstvím a získejte nové zážitky, na které budete vždy rádi vzpomínat. Chystáte se ovládnout zasněžené rampy snowparků? Toužíte si zaplavat se žraloky a nepřijít o nohu? Nezáleží, zda chcete skočit s padákem či do postele, důležité je se bavit.",
                        content_right: "Lidé nelitují věcí, které učinili, ale těch, ke kterým se vůbec neodvážili. Seberte odvahu, ať se ve stáří ohlížíte zpět s dobrým pocitem. Carpe Diem."
                    },
                    education: {
                        title: "education",
                        desc: "rozšířit vzdělání.",
                        content_left: "Nezáleží na tom, jestli studujete cizí jazyky, čtete o pádu Římské říše nebo se snažíte vybojovat titul Ph.D. v matematice. Oblast Vzdělání přináší široký náhled do světa lidské touhy po vědomostech. Nabídneme Vám postřehy, vědomosti a rady uznávaných lektorů, výzkumníků a pedagogů. Tvrdá práce ale zůstává jen a jen na vás.",
                        content_right: "Pamatujte, že škola není jediná cesta za vzděláním a ne každá vědomost je měřitelná srovnávacími zkouškami. Žádný učený z nebe nespadl, proč tedy nezačít právě teď?"
                    },
                    personality: {
                        title: "personality",
                        desc: "být lepší osobností",
                        content_left: "Naše osobnost určuje v mnohém aspekty celého života. S kým se potkáváme, v čem si věříme, čeho jsme schopní dosáhnout, jak nás posuzují ostatní. Osobní pohoda, materiální zabezpečení či pocit zadostiučinění pramení z hodnot, které považujeme za důležité. Někdo se chce stát lepším člověkem, jiný by se rád naučil čelit problémům a stresu.",
                        content_right: "V oblasti Osobnost si rozšíříme obzory o lidských hodnotách, zapracujeme na charakterových nedostatcích a společně zjistíme, jak se stát osobností hodnou uznání."
                    },
                    relations: {
                        title: "relations",
                        desc: "zlepšit své vztahy",
                        content_left: "Budování vztahů není žádný med. Občas se spálíme a jindy získáme přítele na celý život. Jednou z cest jak proniknout do tajemného světa emocí a pocitů je sdílet své zkušenosti a inspirovat se od odborníků. Byli byste rádi v práci obklopeni nejen kolegy, ale přáteli? Vadí vám nedostatek teamového ducha v hokejovém teamu? Naučte se společně s námi, jak najít společnou řeč v každodenním životě.",
                        content_right: "Hlavní myšlenkou oblasti Vztahy je budování a zlepšování vazeb mezi lidmi. Naučme se jak vyjít i s těmi, kdo nejsou naše krevní skupina. Žádná mezilidská překážka není postavena tak vysoko, aby se nedala překonat."
                    },
                    sports: {
                        title: "sports",
                        desc: "více sportovat",
                        content_left: "Rádi byste oprášili kolečka na bruslích? Potřebujete motivaci k pravidelnému kondičnímu běhu? Oblast Sport je plná návodů, tipů a šablon, které vás nakopnou do životní formy. Trénink by měl být přínosný a pravidelný, ale ze všeho nejvíc by měl zůstat zábavou. Ve zdravém těle, zdravý duch!",
                        content_right: "Sport prokazatelně pomáhá bojovat proti stresu a únavě. Zanechme tedy jednou pro vždy výmluv. Neexistuje špatné počasí, jen špatně oblečený sportovec!"
                    },
                    travel: {
                        title: "travel",
                        desc: "cestovat",
                        content_left: "Oblast s názvem Cestování zahrnuje všechny naše sny, plány a nejtajnější cestovatelská přání. Pokud vás již přestalo bavit snít o slunečné pláži, zatímco máte nohy naložené v zahradním lavoru, pak jste dorazili správné místo. Popadněte špendlíky, roztočte globus a popuste fantazii uzdu. Život máme jen jeden.",
                        content_right: "Nekonečné množství zemí, krajin a kultur nás vybízí k tomu objevovat svět a rozšiřovat si obzory. Ne nadarmo se říká, že peníze vložené do cestování vás vždy nakonec obohatí."
                    },
                    articles: {
                        by: "autor",
                        read_more: "VÍCE"
                    }
                },
                lookinside: {
                    title: "Představení",
                    subtitle: "Mobilní aplikace",
                    dreams: {
                        title: "Sny",
                        content: "Místo, kde si můžeš sepsat své sny nebo využít připravené šablony. Rozděl si cíle do splnitelných kroků a vydej se na cestu."
                    },
                    timeline: {
                        title: "Timeline",
                        content: "Naše Timeline ti umožňuje komunikovat s dalšími uživateli a sdílet myšlenky, komentáře a vaše úspěchy."
                    },
                    magazine: {
                        title: "Magazín",
                        content: "Potřebuješ k dosažení svého cíle detailnější informace? Hledáš inspiraci pro další sny? Projdi si články v našem magazínu."
                    },
                    profile: {
                        title: "Profil",
                        content: "Ve svém profilu najdeš osobní nastavení a nástroje, které ti pomohou spojit se s uživateli, kteří sdílí podobné cíle."
                    }
                },
                features: {
                    title: "Funkce",
                    subtitle: "Na co se těšit?",
                    personalized_content: {
                        title: "Obsah šitý na míru",
                        content: "Výběr oblastí jako např. Umění nebo Kariéra nám umožní zúžit množství informací, na ty, které jsou pro tebe opravdu důležité."
                    },
                    dreams_list: {
                        title: "Přehledný seznam snů",
                        content: "Sestavit si cíle nikdy nebylo snazší. Všechny své sny máš u nás jako na dlani."
                    },
                    step_by_step: {
                        title: "Osobní šablony",
                        content: "Šablony jsou tvým osobním průvodcem k vytyčeným cílům. Sleduj ty, kteří svých snů dosáhli, a stavěj na jejich zkušenostech!"
                    },
                    magazine: {
                        title: "Přínosný magazín",
                        content: "Magazín je tím pravým místem, kde lze nalézt nástroje a znalosti, které tě nasměrují na správnou cestu."
                    },
                    community: {
                        title: "Přátelská komunita",
                        content: "Sdílej své úspěchy s přáteli na své zdi a vzájemně se motivujte k lepším výsledkům."
                    },
                    suggestion: {
                        title: "Nechte se inspirovat",
                        content: "Lidé v našem okolí utvářejí náš charakter. Spojíme tě s lidmi, kteří sdílí podobné cíle a jdou vytrvale dál."
                    }
                },
                makeawish: {
                    title: "Splň si přání!",
                    subtitle: "Pošli nám svůj sen.",
                    desc: "Na základě tvých podnětů hledáme osobnosti, které již daných snů dosáhly. Pomocí naší aplikace tak můžeš čerpat z jejich zkušeností.",
                    form: {
                        side_a: {
                            success: "Úspěšně odesláno",
                            error: "Nesprávný tvar e-mailové adresy",
                            placeholder: "Napiš svůj sen.",
                            button: "OK"
                        },
                        side_b: {
                            error: "Zadej svůj sen.",
                            placeholder: "Zadej svůj email.",
                            button: "ODESLAT"
                        }
                    }
                }
            }
        },
        magazine: {
            section_menu: {
                back_to_microsite: "Zpět na microsite"
            }
        }
    }
},
    function(e, t) {
        "object" == typeof module && "object" == typeof module.exports ? module.exports = e.document ? t(e, !0) : function(e) {
            if (!e.document) throw new Error("jQuery requires a window with a document");
            return t(e)
        } : t(e)
    }("undefined" != typeof window ? window : this, function(e, t) {
        function n(e) {
            var t = e.length,
                n = rt.type(e);
            return "function" === n || rt.isWindow(e) ? !1 : 1 === e.nodeType && t ? !0 : "array" === n || 0 === t || "number" == typeof t && t > 0 && t - 1 in e
        }

        function o(e, t, n) {
            if (rt.isFunction(t)) return rt.grep(e, function(e, o) {
                return !!t.call(e, o, e) !== n
            });
            if (t.nodeType) return rt.grep(e, function(e) {
                return e === t !== n
            });
            if ("string" == typeof t) {
                if (ft.test(t)) return rt.filter(t, e, n);
                t = rt.filter(t, e)
            }
            return rt.grep(e, function(e) {
                return rt.inArray(e, t) >= 0 !== n
            })
        }

        function i(e, t) {
            do e = e[t]; while (e && 1 !== e.nodeType);
            return e
        }

        function r(e) {
            var t = kt[e] = {};
            return rt.each(e.match(wt) || [], function(e, n) {
                t[n] = !0
            }), t
        }

        function a() {
            mt.addEventListener ? (mt.removeEventListener("DOMContentLoaded", s, !1), e.removeEventListener("load", s, !1)) : (mt.detachEvent("onreadystatechange", s), e.detachEvent("onload", s))
        }

        function s() {
            (mt.addEventListener || "load" === event.type || "complete" === mt.readyState) && (a(), rt.ready())
        }

        function l(e, t, n) {
            if (void 0 === n && 1 === e.nodeType) {
                var o = "data-" + t.replace(jt, "-$1").toLowerCase();
                if (n = e.getAttribute(o), "string" == typeof n) {
                    try {
                        n = "true" === n ? !0 : "false" === n ? !1 : "null" === n ? null : +n + "" === n ? +n : Tt.test(n) ? rt.parseJSON(n) : n
                    } catch (i) {}
                    rt.data(e, t, n)
                } else n = void 0
            }
            return n
        }

        function u(e) {
            var t;
            for (t in e)
                if (("data" !== t || !rt.isEmptyObject(e[t])) && "toJSON" !== t) return !1;
            return !0
        }

        function c(e, t, n, o) {
            if (rt.acceptData(e)) {
                var i, r, a = rt.expando,
                    s = e.nodeType,
                    l = s ? rt.cache : e,
                    u = s ? e[a] : e[a] && a;
                if (u && l[u] && (o || l[u].data) || void 0 !== n || "string" != typeof t) return u || (u = s ? e[a] = U.pop() || rt.guid++ : a), l[u] || (l[u] = s ? {} : {
                    toJSON: rt.noop
                }), ("object" == typeof t || "function" == typeof t) && (o ? l[u] = rt.extend(l[u], t) : l[u].data = rt.extend(l[u].data, t)), r = l[u], o || (r.data || (r.data = {}), r = r.data), void 0 !== n && (r[rt.camelCase(t)] = n), "string" == typeof t ? (i = r[t], null == i && (i = r[rt.camelCase(t)])) : i = r, i
            }
        }

        function d(e, t, n) {
            if (rt.acceptData(e)) {
                var o, i, r = e.nodeType,
                    a = r ? rt.cache : e,
                    s = r ? e[rt.expando] : rt.expando;
                if (a[s]) {
                    if (t && (o = n ? a[s] : a[s].data)) {
                        rt.isArray(t) ? t = t.concat(rt.map(t, rt.camelCase)) : t in o ? t = [t] : (t = rt.camelCase(t), t = t in o ? [t] : t.split(" ")), i = t.length;
                        for (; i--;) delete o[t[i]];
                        if (n ? !u(o) : !rt.isEmptyObject(o)) return
                    }(n || (delete a[s].data, u(a[s]))) && (r ? rt.cleanData([e], !0) : ot.deleteExpando || a != a.window ? delete a[s] : a[s] = null)
                }
            }
        }

        function p() {
            return !0
        }

        function f() {
            return !1
        }

        function h() {
            try {
                return mt.activeElement
            } catch (e) {}
        }

        function m(e) {
            var t = Ht.split("|"),
                n = e.createDocumentFragment();
            if (n.createElement)
                for (; t.length;) n.createElement(t.pop());
            return n
        }

        function g(e, t) {
            var n, o, i = 0,
                r = typeof e.getElementsByTagName !== Ct ? e.getElementsByTagName(t || "*") : typeof e.querySelectorAll !== Ct ? e.querySelectorAll(t || "*") : void 0;
            if (!r)
                for (r = [], n = e.childNodes || e; null != (o = n[i]); i++) !t || rt.nodeName(o, t) ? r.push(o) : rt.merge(r, g(o, t));
            return void 0 === t || t && rt.nodeName(e, t) ? rt.merge([e], r) : r
        }

        function v(e) {
            zt.test(e.type) && (e.defaultChecked = e.checked)
        }

        function y(e, t) {
            return rt.nodeName(e, "table") && rt.nodeName(11 !== t.nodeType ? t : t.firstChild, "tr") ? e.getElementsByTagName("tbody")[0] || e.appendChild(e.ownerDocument.createElement("tbody")) : e
        }

        function b(e) {
            return e.type = (null !== rt.find.attr(e, "type")) + "/" + e.type, e
        }

        function w(e) {
            var t = Ut.exec(e.type);
            return t ? e.type = t[1] : e.removeAttribute("type"), e
        }

        function k(e, t) {
            for (var n, o = 0; null != (n = e[o]); o++) rt._data(n, "globalEval", !t || rt._data(t[o], "globalEval"))
        }

        function x(e, t) {
            if (1 === t.nodeType && rt.hasData(e)) {
                var n, o, i, r = rt._data(e),
                    a = rt._data(t, r),
                    s = r.events;
                if (s) {
                    delete a.handle, a.events = {};
                    for (n in s)
                        for (o = 0, i = s[n].length; i > o; o++) rt.event.add(t, n, s[n][o])
                }
                a.data && (a.data = rt.extend({}, a.data))
            }
        }

        function _(e, t) {
            var n, o, i;
            if (1 === t.nodeType) {
                if (n = t.nodeName.toLowerCase(), !ot.noCloneEvent && t[rt.expando]) {
                    i = rt._data(t);
                    for (o in i.events) rt.removeEvent(t, o, i.handle);
                    t.removeAttribute(rt.expando)
                }
                "script" === n && t.text !== e.text ? (b(t).text = e.text, w(t)) : "object" === n ? (t.parentNode && (t.outerHTML = e.outerHTML), ot.html5Clone && e.innerHTML && !rt.trim(t.innerHTML) && (t.innerHTML = e.innerHTML)) : "input" === n && zt.test(e.type) ? (t.defaultChecked = t.checked = e.checked, t.value !== e.value && (t.value = e.value)) : "option" === n ? t.defaultSelected = t.selected = e.defaultSelected : ("input" === n || "textarea" === n) && (t.defaultValue = e.defaultValue)
            }
        }

        function C(t, n) {
            var o = rt(n.createElement(t)).appendTo(n.body),
                i = e.getDefaultComputedStyle ? e.getDefaultComputedStyle(o[0]).display : rt.css(o[0], "display");
            return o.detach(), i
        }

        function T(e) {
            var t = mt,
                n = en[e];
            return n || (n = C(e, t), "none" !== n && n || (Zt = (Zt || rt("<iframe frameborder='0' width='0' height='0'/>")).appendTo(t.documentElement), t = (Zt[0].contentWindow || Zt[0].contentDocument).document, t.write(), t.close(), n = C(e, t), Zt.detach()), en[e] = n), n
        }

        function j(e, t) {
            return {
                get: function() {
                    var n = e();
                    if (null != n) return n ? (delete this.get, void 0) : (this.get = t).apply(this, arguments)
                }
            }
        }

        function S(e, t) {
            if (t in e) return t;
            for (var n = t.charAt(0).toUpperCase() + t.slice(1), o = t, i = hn.length; i--;)
                if (t = hn[i] + n, t in e) return t;
            return o
        }

        function $(e, t) {
            for (var n, o, i, r = [], a = 0, s = e.length; s > a; a++) o = e[a], o.style && (r[a] = rt._data(o, "olddisplay"), n = o.style.display, t ? (r[a] || "none" !== n || (o.style.display = ""), "" === o.style.display && Et(o) && (r[a] = rt._data(o, "olddisplay", T(o.nodeName)))) : r[a] || (i = Et(o), (n && "none" !== n || !i) && rt._data(o, "olddisplay", i ? n : rt.css(o, "display"))));
            for (a = 0; s > a; a++) o = e[a], o.style && (t && "none" !== o.style.display && "" !== o.style.display || (o.style.display = t ? r[a] || "" : "none"));
            return e
        }

        function E(e, t, n) {
            var o = cn.exec(t);
            return o ? Math.max(0, o[1] - (n || 0)) + (o[2] || "px") : t
        }

        function N(e, t, n, o, i) {
            for (var r = n === (o ? "border" : "content") ? 4 : "width" === t ? 1 : 0, a = 0; 4 > r; r += 2) "margin" === n && (a += rt.css(e, n + $t[r], !0, i)), o ? ("content" === n && (a -= rt.css(e, "padding" + $t[r], !0, i)), "margin" !== n && (a -= rt.css(e, "border" + $t[r] + "Width", !0, i))) : (a += rt.css(e, "padding" + $t[r], !0, i), "padding" !== n && (a += rt.css(e, "border" + $t[r] + "Width", !0, i)));
            return a
        }

        function z(e, t, n) {
            var o = !0,
                i = "width" === t ? e.offsetWidth : e.offsetHeight,
                r = tn(e),
                a = ot.boxSizing() && "border-box" === rt.css(e, "boxSizing", !1, r);
            if (0 >= i || null == i) {
                if (i = nn(e, t, r), (0 > i || null == i) && (i = e.style[t]), rn.test(i)) return i;
                o = a && (ot.boxSizingReliable() || i === e.style[t]), i = parseFloat(i) || 0
            }
            return i + N(e, t, n || (a ? "border" : "content"), o, r) + "px"
        }

        function A(e, t, n, o, i) {
            return new A.prototype.init(e, t, n, o, i)
        }

        function L() {
            return setTimeout(function() {
                mn = void 0
            }), mn = rt.now()
        }

        function D(e, t) {
            var n, o = {
                    height: e
                },
                i = 0;
            for (t = t ? 1 : 0; 4 > i; i += 2 - t) n = $t[i], o["margin" + n] = o["padding" + n] = e;
            return t && (o.opacity = o.width = e), o
        }

        function M(e, t, n) {
            for (var o, i = (kn[t] || []).concat(kn["*"]), r = 0, a = i.length; a > r; r++)
                if (o = i[r].call(n, t, e)) return o
        }

        function I(e, t, n) {
            var o, i, r, a, s, l, u, c, d = this,
                p = {},
                f = e.style,
                h = e.nodeType && Et(e),
                m = rt._data(e, "fxshow");
            n.queue || (s = rt._queueHooks(e, "fx"), null == s.unqueued && (s.unqueued = 0, l = s.empty.fire, s.empty.fire = function() {
                s.unqueued || l()
            }), s.unqueued++, d.always(function() {
                d.always(function() {
                    s.unqueued--, rt.queue(e, "fx").length || s.empty.fire()
                })
            })), 1 === e.nodeType && ("height" in t || "width" in t) && (n.overflow = [f.overflow, f.overflowX, f.overflowY], u = rt.css(e, "display"), c = T(e.nodeName), "none" === u && (u = c), "inline" === u && "none" === rt.css(e, "float") && (ot.inlineBlockNeedsLayout && "inline" !== c ? f.zoom = 1 : f.display = "inline-block")), n.overflow && (f.overflow = "hidden", ot.shrinkWrapBlocks() || d.always(function() {
                f.overflow = n.overflow[0], f.overflowX = n.overflow[1], f.overflowY = n.overflow[2]
            }));
            for (o in t)
                if (i = t[o], vn.exec(i)) {
                    if (delete t[o], r = r || "toggle" === i, i === (h ? "hide" : "show")) {
                        if ("show" !== i || !m || void 0 === m[o]) continue;
                        h = !0
                    }
                    p[o] = m && m[o] || rt.style(e, o)
                }
            if (!rt.isEmptyObject(p)) {
                m ? "hidden" in m && (h = m.hidden) : m = rt._data(e, "fxshow", {}), r && (m.hidden = !h), h ? rt(e).show() : d.done(function() {
                    rt(e).hide()
                }), d.done(function() {
                    var t;
                    rt._removeData(e, "fxshow");
                    for (t in p) rt.style(e, t, p[t])
                });
                for (o in p) a = M(h ? m[o] : 0, o, d), o in m || (m[o] = a.start, h && (a.end = a.start, a.start = "width" === o || "height" === o ? 1 : 0))
            }
        }

        function H(e, t) {
            var n, o, i, r, a;
            for (n in e)
                if (o = rt.camelCase(n), i = t[o], r = e[n], rt.isArray(r) && (i = r[1], r = e[n] = r[0]), n !== o && (e[o] = r, delete e[n]), a = rt.cssHooks[o], a && "expand" in a) {
                    r = a.expand(r), delete e[o];
                    for (n in r) n in e || (e[n] = r[n], t[n] = i)
                } else t[o] = i
        }

        function P(e, t, n) {
            var o, i, r = 0,
                a = wn.length,
                s = rt.Deferred().always(function() {
                    delete l.elem
                }),
                l = function() {
                    if (i) return !1;
                    for (var t = mn || L(), n = Math.max(0, u.startTime + u.duration - t), o = n / u.duration || 0, r = 1 - o, a = 0, l = u.tweens.length; l > a; a++) u.tweens[a].run(r);
                    return s.notifyWith(e, [u, r, n]), 1 > r && l ? n : (s.resolveWith(e, [u]), !1)
                },
                u = s.promise({
                    elem: e,
                    props: rt.extend({}, t),
                    opts: rt.extend(!0, {
                        specialEasing: {}
                    }, n),
                    originalProperties: t,
                    originalOptions: n,
                    startTime: mn || L(),
                    duration: n.duration,
                    tweens: [],
                    createTween: function(t, n) {
                        var o = rt.Tween(e, u.opts, t, n, u.opts.specialEasing[t] || u.opts.easing);
                        return u.tweens.push(o), o
                    },
                    stop: function(t) {
                        var n = 0,
                            o = t ? u.tweens.length : 0;
                        if (i) return this;
                        for (i = !0; o > n; n++) u.tweens[n].run(1);
                        return t ? s.resolveWith(e, [u, t]) : s.rejectWith(e, [u, t]), this
                    }
                }),
                c = u.props;
            for (H(c, u.opts.specialEasing); a > r; r++)
                if (o = wn[r].call(u, e, c, u.opts)) return o;
            return rt.map(c, M, u), rt.isFunction(u.opts.start) && u.opts.start.call(e, u), rt.fx.timer(rt.extend(l, {
                elem: e,
                anim: u,
                queue: u.opts.queue
            })), u.progress(u.opts.progress).done(u.opts.done, u.opts.complete).fail(u.opts.fail).always(u.opts.always)
        }

        function O(e) {
            return function(t, n) {
                "string" != typeof t && (n = t, t = "*");
                var o, i = 0,
                    r = t.toLowerCase().match(wt) || [];
                if (rt.isFunction(n))
                    for (; o = r[i++];) "+" === o.charAt(0) ? (o = o.slice(1) || "*", (e[o] = e[o] || []).unshift(n)) : (e[o] = e[o] || []).push(n)
            }
        }

        function B(e, t, n, o) {
            function i(s) {
                var l;
                return r[s] = !0, rt.each(e[s] || [], function(e, s) {
                    var u = s(t, n, o);
                    return "string" != typeof u || a || r[u] ? a ? !(l = u) : void 0 : (t.dataTypes.unshift(u), i(u), !1)
                }), l
            }
            var r = {},
                a = e === Yn;
            return i(t.dataTypes[0]) || !r["*"] && i("*")
        }

        function F(e, t) {
            var n, o, i = rt.ajaxSettings.flatOptions || {};
            for (o in t) void 0 !== t[o] && ((i[o] ? e : n || (n = {}))[o] = t[o]);
            return n && rt.extend(!0, e, n), e
        }

        function q(e, t, n) {
            for (var o, i, r, a, s = e.contents, l = e.dataTypes;
                 "*" === l[0];) l.shift(), void 0 === i && (i = e.mimeType || t.getResponseHeader("Content-Type"));
            if (i)
                for (a in s)
                    if (s[a] && s[a].test(i)) {
                        l.unshift(a);
                        break
                    }
            if (l[0] in n) r = l[0];
            else {
                for (a in n) {
                    if (!l[0] || e.converters[a + " " + l[0]]) {
                        r = a;
                        break
                    }
                    o || (o = a)
                }
                r = r || o
            }
            return r ? (r !== l[0] && l.unshift(r), n[r]) : void 0
        }

        function R(e, t, n, o) {
            var i, r, a, s, l, u = {},
                c = e.dataTypes.slice();
            if (c[1])
                for (a in e.converters) u[a.toLowerCase()] = e.converters[a];
            for (r = c.shift(); r;)
                if (e.responseFields[r] && (n[e.responseFields[r]] = t), !l && o && e.dataFilter && (t = e.dataFilter(t, e.dataType)), l = r, r = c.shift())
                    if ("*" === r) r = l;
                    else if ("*" !== l && l !== r) {
                        if (a = u[l + " " + r] || u["* " + r], !a)
                            for (i in u)
                                if (s = i.split(" "), s[1] === r && (a = u[l + " " + s[0]] || u["* " + s[0]])) {
                                    a === !0 ? a = u[i] : u[i] !== !0 && (r = s[0], c.unshift(s[1]));
                                    break
                                }
                        if (a !== !0)
                            if (a && e["throws"]) t = a(t);
                            else try {
                                t = a(t)
                            } catch (d) {
                                return {
                                    state: "parsererror",
                                    error: a ? d : "No conversion from " + l + " to " + r
                                }
                            }
                    }
            return {
                state: "success",
                data: t
            }
        }

        function W(e, t, n, o) {
            var i;
            if (rt.isArray(t)) rt.each(t, function(t, i) {
                n || Jn.test(e) ? o(e, i) : W(e + "[" + ("object" == typeof i ? t : "") + "]", i, n, o)
            });
            else if (n || "object" !== rt.type(t)) o(e, t);
            else
                for (i in t) W(e + "[" + i + "]", t[i], n, o)
        }

        function Y() {
            try {
                return new e.XMLHttpRequest
            } catch (t) {}
        }

        function X() {
            try {
                return new e.ActiveXObject("Microsoft.XMLHTTP")
            } catch (t) {}
        }

        function V(e) {
            return rt.isWindow(e) ? e : 9 === e.nodeType ? e.defaultView || e.parentWindow : !1
        }
        var U = [],
            J = U.slice,
            Q = U.concat,
            K = U.push,
            G = U.indexOf,
            Z = {},
            et = Z.toString,
            tt = Z.hasOwnProperty,
            nt = "".trim,
            ot = {},
            it = "1.11.0",
            rt = function(e, t) {
                return new rt.fn.init(e, t)
            },
            at = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g,
            st = /^-ms-/,
            lt = /-([\da-z])/gi,
            ut = function(e, t) {
                return t.toUpperCase()
            };
        rt.fn = rt.prototype = {
            jquery: it,
            constructor: rt,
            selector: "",
            length: 0,
            toArray: function() {
                return J.call(this)
            },
            get: function(e) {
                return null != e ? 0 > e ? this[e + this.length] : this[e] : J.call(this)
            },
            pushStack: function(e) {
                var t = rt.merge(this.constructor(), e);
                return t.prevObject = this, t.context = this.context, t
            },
            each: function(e, t) {
                return rt.each(this, e, t)
            },
            map: function(e) {
                return this.pushStack(rt.map(this, function(t, n) {
                    return e.call(t, n, t)
                }))
            },
            slice: function() {
                return this.pushStack(J.apply(this, arguments))
            },
            first: function() {
                return this.eq(0)
            },
            last: function() {
                return this.eq(-1)
            },
            eq: function(e) {
                var t = this.length,
                    n = +e + (0 > e ? t : 0);
                return this.pushStack(n >= 0 && t > n ? [this[n]] : [])
            },
            end: function() {
                return this.prevObject || this.constructor(null)
            },
            push: K,
            sort: U.sort,
            splice: U.splice
        }, rt.extend = rt.fn.extend = function() {
            var e, t, n, o, i, r, a = arguments[0] || {},
                s = 1,
                l = arguments.length,
                u = !1;
            for ("boolean" == typeof a && (u = a, a = arguments[s] || {}, s++), "object" == typeof a || rt.isFunction(a) || (a = {}), s === l && (a = this, s--); l > s; s++)
                if (null != (i = arguments[s]))
                    for (o in i) e = a[o], n = i[o], a !== n && (u && n && (rt.isPlainObject(n) || (t = rt.isArray(n))) ? (t ? (t = !1, r = e && rt.isArray(e) ? e : []) : r = e && rt.isPlainObject(e) ? e : {}, a[o] = rt.extend(u, r, n)) : void 0 !== n && (a[o] = n));
            return a
        }, rt.extend({
            expando: "jQuery" + (it + Math.random()).replace(/\D/g, ""),
            isReady: !0,
            error: function(e) {
                throw new Error(e)
            },
            noop: function() {},
            isFunction: function(e) {
                return "function" === rt.type(e)
            },
            isArray: Array.isArray || function(e) {
                return "array" === rt.type(e)
            },
            isWindow: function(e) {
                return null != e && e == e.window
            },
            isNumeric: function(e) {
                return e - parseFloat(e) >= 0
            },
            isEmptyObject: function(e) {
                var t;
                for (t in e) return !1;
                return !0
            },
            isPlainObject: function(e) {
                var t;
                if (!e || "object" !== rt.type(e) || e.nodeType || rt.isWindow(e)) return !1;
                try {
                    if (e.constructor && !tt.call(e, "constructor") && !tt.call(e.constructor.prototype, "isPrototypeOf")) return !1
                } catch (n) {
                    return !1
                }
                if (ot.ownLast)
                    for (t in e) return tt.call(e, t);
                for (t in e);
                return void 0 === t || tt.call(e, t)
            },
            type: function(e) {
                return null == e ? e + "" : "object" == typeof e || "function" == typeof e ? Z[et.call(e)] || "object" : typeof e
            },
            globalEval: function(t) {
                t && rt.trim(t) && (e.execScript || function(t) {
                    e.eval.call(e, t)
                })(t)
            },
            camelCase: function(e) {
                return e.replace(st, "ms-").replace(lt, ut)
            },
            nodeName: function(e, t) {
                return e.nodeName && e.nodeName.toLowerCase() === t.toLowerCase()
            },
            each: function(e, t, o) {
                var i, r = 0,
                    a = e.length,
                    s = n(e);
                if (o) {
                    if (s)
                        for (; a > r && (i = t.apply(e[r], o), i !== !1); r++);
                    else
                        for (r in e)
                            if (i = t.apply(e[r], o), i === !1) break
                } else if (s)
                    for (; a > r && (i = t.call(e[r], r, e[r]), i !== !1); r++);
                else
                    for (r in e)
                        if (i = t.call(e[r], r, e[r]), i === !1) break; return e
            },
            trim: nt && !nt.call("﻿ ") ? function(e) {
                return null == e ? "" : nt.call(e)
            } : function(e) {
                return null == e ? "" : (e + "").replace(at, "")
            },
            makeArray: function(e, t) {
                var o = t || [];
                return null != e && (n(Object(e)) ? rt.merge(o, "string" == typeof e ? [e] : e) : K.call(o, e)), o
            },
            inArray: function(e, t, n) {
                var o;
                if (t) {
                    if (G) return G.call(t, e, n);
                    for (o = t.length, n = n ? 0 > n ? Math.max(0, o + n) : n : 0; o > n; n++)
                        if (n in t && t[n] === e) return n
                }
                return -1
            },
            merge: function(e, t) {
                for (var n = +t.length, o = 0, i = e.length; n > o;) e[i++] = t[o++];
                if (n !== n)
                    for (; void 0 !== t[o];) e[i++] = t[o++];
                return e.length = i, e
            },
            grep: function(e, t, n) {
                for (var o, i = [], r = 0, a = e.length, s = !n; a > r; r++) o = !t(e[r], r), o !== s && i.push(e[r]);
                return i
            },
            map: function(e, t, o) {
                var i, r = 0,
                    a = e.length,
                    s = n(e),
                    l = [];
                if (s)
                    for (; a > r; r++) i = t(e[r], r, o), null != i && l.push(i);
                else
                    for (r in e) i = t(e[r], r, o), null != i && l.push(i);
                return Q.apply([], l)
            },
            guid: 1,
            proxy: function(e, t) {
                var n, o, i;
                return "string" == typeof t && (i = e[t], t = e, e = i), rt.isFunction(e) ? (n = J.call(arguments, 2), o = function() {
                    return e.apply(t || this, n.concat(J.call(arguments)))
                }, o.guid = e.guid = e.guid || rt.guid++, o) : void 0
            },
            now: function() {
                return +new Date
            },
            support: ot
        }), rt.each("Boolean Number String Function Array Date RegExp Object Error".split(" "), function(e, t) {
            Z["[object " + t + "]"] = t.toLowerCase()
        });
        var ct = function(e) {
            function t(e, t, n, o) {
                var i, r, a, s, l, u, d, h, m, g;
                if ((t ? t.ownerDocument || t : B) !== A && z(t), t = t || A, n = n || [], !e || "string" != typeof e) return n;
                if (1 !== (s = t.nodeType) && 9 !== s) return [];
                if (D && !o) {
                    if (i = yt.exec(e))
                        if (a = i[1]) {
                            if (9 === s) {
                                if (r = t.getElementById(a), !r || !r.parentNode) return n;
                                if (r.id === a) return n.push(r), n
                            } else if (t.ownerDocument && (r = t.ownerDocument.getElementById(a)) && P(t, r) && r.id === a) return n.push(r), n
                        } else {
                            if (i[2]) return Z.apply(n, t.getElementsByTagName(e)), n;
                            if ((a = i[3]) && _.getElementsByClassName && t.getElementsByClassName) return Z.apply(n, t.getElementsByClassName(a)), n
                        }
                    if (_.qsa && (!M || !M.test(e))) {
                        if (h = d = O, m = t, g = 9 === s && e, 1 === s && "object" !== t.nodeName.toLowerCase()) {
                            for (u = p(e), (d = t.getAttribute("id")) ? h = d.replace(wt, "\\$&") : t.setAttribute("id", h), h = "[id='" + h + "'] ", l = u.length; l--;) u[l] = h + f(u[l]);
                            m = bt.test(e) && c(t.parentNode) || t, g = u.join(",")
                        }
                        if (g) try {
                            return Z.apply(n, m.querySelectorAll(g)), n
                        } catch (v) {} finally {
                            d || t.removeAttribute("id")
                        }
                    }
                }
                return k(e.replace(lt, "$1"), t, n, o)
            }

            function n() {
                function e(n, o) {
                    return t.push(n + " ") > C.cacheLength && delete e[t.shift()], e[n + " "] = o
                }
                var t = [];
                return e
            }

            function o(e) {
                return e[O] = !0, e
            }

            function i(e) {
                var t = A.createElement("div");
                try {
                    return !!e(t)
                } catch (n) {
                    return !1
                } finally {
                    t.parentNode && t.parentNode.removeChild(t), t = null
                }
            }

            function r(e, t) {
                for (var n = e.split("|"), o = e.length; o--;) C.attrHandle[n[o]] = t
            }

            function a(e, t) {
                var n = t && e,
                    o = n && 1 === e.nodeType && 1 === t.nodeType && (~t.sourceIndex || U) - (~e.sourceIndex || U);
                if (o) return o;
                if (n)
                    for (; n = n.nextSibling;)
                        if (n === t) return -1;
                return e ? 1 : -1
            }

            function s(e) {
                return function(t) {
                    var n = t.nodeName.toLowerCase();
                    return "input" === n && t.type === e
                }
            }

            function l(e) {
                return function(t) {
                    var n = t.nodeName.toLowerCase();
                    return ("input" === n || "button" === n) && t.type === e
                }
            }

            function u(e) {
                return o(function(t) {
                    return t = +t, o(function(n, o) {
                        for (var i, r = e([], n.length, t), a = r.length; a--;) n[i = r[a]] && (n[i] = !(o[i] = n[i]))
                    })
                })
            }

            function c(e) {
                return e && typeof e.getElementsByTagName !== V && e
            }

            function d() {}

            function p(e, n) {
                var o, i, r, a, s, l, u, c = W[e + " "];
                if (c) return n ? 0 : c.slice(0);
                for (s = e, l = [], u = C.preFilter; s;) {
                    (!o || (i = ut.exec(s))) && (i && (s = s.slice(i[0].length) || s), l.push(r = [])), o = !1, (i = ct.exec(s)) && (o = i.shift(), r.push({
                        value: o,
                        type: i[0].replace(lt, " ")
                    }), s = s.slice(o.length));
                    for (a in C.filter) !(i = ht[a].exec(s)) || u[a] && !(i = u[a](i)) || (o = i.shift(), r.push({
                        value: o,
                        type: a,
                        matches: i
                    }), s = s.slice(o.length));
                    if (!o) break
                }
                return n ? s.length : s ? t.error(e) : W(e, l).slice(0)
            }

            function f(e) {
                for (var t = 0, n = e.length, o = ""; n > t; t++) o += e[t].value;
                return o
            }

            function h(e, t, n) {
                var o = t.dir,
                    i = n && "parentNode" === o,
                    r = q++;
                return t.first ? function(t, n, r) {
                    for (; t = t[o];)
                        if (1 === t.nodeType || i) return e(t, n, r)
                } : function(t, n, a) {
                    var s, l, u = [F, r];
                    if (a) {
                        for (; t = t[o];)
                            if ((1 === t.nodeType || i) && e(t, n, a)) return !0
                    } else
                        for (; t = t[o];)
                            if (1 === t.nodeType || i) {
                                if (l = t[O] || (t[O] = {}), (s = l[o]) && s[0] === F && s[1] === r) return u[2] = s[2];
                                if (l[o] = u, u[2] = e(t, n, a)) return !0
                            }
                }
            }

            function m(e) {
                return e.length > 1 ? function(t, n, o) {
                    for (var i = e.length; i--;)
                        if (!e[i](t, n, o)) return !1;
                    return !0
                } : e[0]
            }

            function g(e, t, n, o, i) {
                for (var r, a = [], s = 0, l = e.length, u = null != t; l > s; s++)(r = e[s]) && (!n || n(r, o, i)) && (a.push(r), u && t.push(s));
                return a
            }

            function v(e, t, n, i, r, a) {
                return i && !i[O] && (i = v(i)), r && !r[O] && (r = v(r, a)), o(function(o, a, s, l) {
                    var u, c, d, p = [],
                        f = [],
                        h = a.length,
                        m = o || w(t || "*", s.nodeType ? [s] : s, []),
                        v = !e || !o && t ? m : g(m, p, e, s, l),
                        y = n ? r || (o ? e : h || i) ? [] : a : v;
                    if (n && n(v, y, s, l), i)
                        for (u = g(y, f), i(u, [], s, l), c = u.length; c--;)(d = u[c]) && (y[f[c]] = !(v[f[c]] = d));
                    if (o) {
                        if (r || e) {
                            if (r) {
                                for (u = [], c = y.length; c--;)(d = y[c]) && u.push(v[c] = d);
                                r(null, y = [], u, l)
                            }
                            for (c = y.length; c--;)(d = y[c]) && (u = r ? tt.call(o, d) : p[c]) > -1 && (o[u] = !(a[u] = d))
                        }
                    } else y = g(y === a ? y.splice(h, y.length) : y), r ? r(null, a, y, l) : Z.apply(a, y)
                })
            }

            function y(e) {
                for (var t, n, o, i = e.length, r = C.relative[e[0].type], a = r || C.relative[" "], s = r ? 1 : 0, l = h(function(e) {
                    return e === t
                }, a, !0), u = h(function(e) {
                    return tt.call(t, e) > -1
                }, a, !0), c = [function(e, n, o) {
                    return !r && (o || n !== $) || ((t = n).nodeType ? l(e, n, o) : u(e, n, o))
                }]; i > s; s++)
                    if (n = C.relative[e[s].type]) c = [h(m(c), n)];
                    else {
                        if (n = C.filter[e[s].type].apply(null, e[s].matches), n[O]) {
                            for (o = ++s; i > o && !C.relative[e[o].type]; o++);
                            return v(s > 1 && m(c), s > 1 && f(e.slice(0, s - 1).concat({
                                    value: " " === e[s - 2].type ? "*" : ""
                                })).replace(lt, "$1"), n, o > s && y(e.slice(s, o)), i > o && y(e = e.slice(o)), i > o && f(e))
                        }
                        c.push(n)
                    }
                return m(c)
            }

            function b(e, n) {
                var i = n.length > 0,
                    r = e.length > 0,
                    a = function(o, a, s, l, u) {
                        var c, d, p, f = 0,
                            h = "0",
                            m = o && [],
                            v = [],
                            y = $,
                            b = o || r && C.find.TAG("*", u),
                            w = F += null == y ? 1 : Math.random() || .1,
                            k = b.length;
                        for (u && ($ = a !== A && a); h !== k && null != (c = b[h]); h++) {
                            if (r && c) {
                                for (d = 0; p = e[d++];)
                                    if (p(c, a, s)) {
                                        l.push(c);
                                        break
                                    }
                                u && (F = w)
                            }
                            i && ((c = !p && c) && f--, o && m.push(c))
                        }
                        if (f += h, i && h !== f) {
                            for (d = 0; p = n[d++];) p(m, v, a, s);
                            if (o) {
                                if (f > 0)
                                    for (; h--;) m[h] || v[h] || (v[h] = K.call(l));
                                v = g(v)
                            }
                            Z.apply(l, v), u && !o && v.length > 0 && f + n.length > 1 && t.uniqueSort(l)
                        }
                        return u && (F = w, $ = y), m
                    };
                return i ? o(a) : a
            }

            function w(e, n, o) {
                for (var i = 0, r = n.length; r > i; i++) t(e, n[i], o);
                return o
            }

            function k(e, t, n, o) {
                var i, r, a, s, l, u = p(e);
                if (!o && 1 === u.length) {
                    if (r = u[0] = u[0].slice(0), r.length > 2 && "ID" === (a = r[0]).type && _.getById && 9 === t.nodeType && D && C.relative[r[1].type]) {
                        if (t = (C.find.ID(a.matches[0].replace(kt, xt), t) || [])[0], !t) return n;
                        e = e.slice(r.shift().value.length)
                    }
                    for (i = ht.needsContext.test(e) ? 0 : r.length; i-- && (a = r[i], !C.relative[s = a.type]);)
                        if ((l = C.find[s]) && (o = l(a.matches[0].replace(kt, xt), bt.test(r[0].type) && c(t.parentNode) || t))) {
                            if (r.splice(i, 1), e = o.length && f(r), !e) return Z.apply(n, o), n;
                            break
                        }
                }
                return S(e, u)(o, t, !D, n, bt.test(e) && c(t.parentNode) || t), n
            }
            var x, _, C, T, j, S, $, E, N, z, A, L, D, M, I, H, P, O = "sizzle" + -new Date,
                B = e.document,
                F = 0,
                q = 0,
                R = n(),
                W = n(),
                Y = n(),
                X = function(e, t) {
                    return e === t && (N = !0), 0
                },
                V = "undefined",
                U = 1 << 31,
                J = {}.hasOwnProperty,
                Q = [],
                K = Q.pop,
                G = Q.push,
                Z = Q.push,
                et = Q.slice,
                tt = Q.indexOf || function(e) {
                        for (var t = 0, n = this.length; n > t; t++)
                            if (this[t] === e) return t;
                        return -1
                    },
                nt = "checked|selected|async|autofocus|autoplay|controls|defer|disabled|hidden|ismap|loop|multiple|open|readonly|required|scoped",
                ot = "[\\x20\\t\\r\\n\\f]",
                it = "(?:\\\\.|[\\w-]|[^\\x00-\\xa0])+",
                rt = it.replace("w", "w#"),
                at = "\\[" + ot + "*(" + it + ")" + ot + "*(?:([*^$|!~]?=)" + ot + "*(?:(['\"])((?:\\\\.|[^\\\\])*?)\\3|(" + rt + ")|)|)" + ot + "*\\]",
                st = ":(" + it + ")(?:\\(((['\"])((?:\\\\.|[^\\\\])*?)\\3|((?:\\\\.|[^\\\\()[\\]]|" + at.replace(3, 8) + ")*)|.*)\\)|)",
                lt = new RegExp("^" + ot + "+|((?:^|[^\\\\])(?:\\\\.)*)" + ot + "+$", "g"),
                ut = new RegExp("^" + ot + "*," + ot + "*"),
                ct = new RegExp("^" + ot + "*([>+~]|" + ot + ")" + ot + "*"),
                dt = new RegExp("=" + ot + "*([^\\]'\"]*?)" + ot + "*\\]", "g"),
                pt = new RegExp(st),
                ft = new RegExp("^" + rt + "$"),
                ht = {
                    ID: new RegExp("^#(" + it + ")"),
                    CLASS: new RegExp("^\\.(" + it + ")"),
                    TAG: new RegExp("^(" + it.replace("w", "w*") + ")"),
                    ATTR: new RegExp("^" + at),
                    PSEUDO: new RegExp("^" + st),
                    CHILD: new RegExp("^:(only|first|last|nth|nth-last)-(child|of-type)(?:\\(" + ot + "*(even|odd|(([+-]|)(\\d*)n|)" + ot + "*(?:([+-]|)" + ot + "*(\\d+)|))" + ot + "*\\)|)", "i"),
                    bool: new RegExp("^(?:" + nt + ")$", "i"),
                    needsContext: new RegExp("^" + ot + "*[>+~]|:(even|odd|eq|gt|lt|nth|first|last)(?:\\(" + ot + "*((?:-\\d)?\\d*)" + ot + "*\\)|)(?=[^-]|$)", "i")
                },
                mt = /^(?:input|select|textarea|button)$/i,
                gt = /^h\d$/i,
                vt = /^[^{]+\{\s*\[native \w/,
                yt = /^(?:#([\w-]+)|(\w+)|\.([\w-]+))$/,
                bt = /[+~]/,
                wt = /'|\\/g,
                kt = new RegExp("\\\\([\\da-f]{1,6}" + ot + "?|(" + ot + ")|.)", "ig"),
                xt = function(e, t, n) {
                    var o = "0x" + t - 65536;
                    return o !== o || n ? t : 0 > o ? String.fromCharCode(o + 65536) : String.fromCharCode(o >> 10 | 55296, 1023 & o | 56320)
                };
            try {
                Z.apply(Q = et.call(B.childNodes), B.childNodes), Q[B.childNodes.length].nodeType
            } catch (_t) {
                Z = {
                    apply: Q.length ? function(e, t) {
                        G.apply(e, et.call(t))
                    } : function(e, t) {
                        for (var n = e.length, o = 0; e[n++] = t[o++];);
                        e.length = n - 1
                    }
                }
            }
            _ = t.support = {}, j = t.isXML = function(e) {
                var t = e && (e.ownerDocument || e).documentElement;
                return t ? "HTML" !== t.nodeName : !1
            }, z = t.setDocument = function(e) {
                var t, n = e ? e.ownerDocument || e : B,
                    o = n.defaultView;
                return n !== A && 9 === n.nodeType && n.documentElement ? (A = n, L = n.documentElement, D = !j(n), o && o !== o.top && (o.addEventListener ? o.addEventListener("unload", function() {
                    z()
                }, !1) : o.attachEvent && o.attachEvent("onunload", function() {
                    z()
                })), _.attributes = i(function(e) {
                    return e.className = "i", !e.getAttribute("className")
                }), _.getElementsByTagName = i(function(e) {
                    return e.appendChild(n.createComment("")), !e.getElementsByTagName("*").length
                }), _.getElementsByClassName = vt.test(n.getElementsByClassName) && i(function(e) {
                        return e.innerHTML = "<div class='a'></div><div class='a i'></div>", e.firstChild.className = "i", 2 === e.getElementsByClassName("i").length
                    }), _.getById = i(function(e) {
                    return L.appendChild(e).id = O, !n.getElementsByName || !n.getElementsByName(O).length
                }), _.getById ? (C.find.ID = function(e, t) {
                    if (typeof t.getElementById !== V && D) {
                        var n = t.getElementById(e);
                        return n && n.parentNode ? [n] : []
                    }
                }, C.filter.ID = function(e) {
                    var t = e.replace(kt, xt);
                    return function(e) {
                        return e.getAttribute("id") === t
                    }
                }) : (delete C.find.ID, C.filter.ID = function(e) {
                    var t = e.replace(kt, xt);
                    return function(e) {
                        var n = typeof e.getAttributeNode !== V && e.getAttributeNode("id");
                        return n && n.value === t
                    }
                }), C.find.TAG = _.getElementsByTagName ? function(e, t) {
                    return typeof t.getElementsByTagName !== V ? t.getElementsByTagName(e) : void 0
                } : function(e, t) {
                    var n, o = [],
                        i = 0,
                        r = t.getElementsByTagName(e);
                    if ("*" === e) {
                        for (; n = r[i++];) 1 === n.nodeType && o.push(n);
                        return o
                    }
                    return r
                }, C.find.CLASS = _.getElementsByClassName && function(e, t) {
                        return typeof t.getElementsByClassName !== V && D ? t.getElementsByClassName(e) : void 0
                    }, I = [], M = [], (_.qsa = vt.test(n.querySelectorAll)) && (i(function(e) {
                    e.innerHTML = "<select t=''><option selected=''></option></select>", e.querySelectorAll("[t^='']").length && M.push("[*^$]=" + ot + "*(?:''|\"\")"), e.querySelectorAll("[selected]").length || M.push("\\[" + ot + "*(?:value|" + nt + ")"), e.querySelectorAll(":checked").length || M.push(":checked")
                }), i(function(e) {
                    var t = n.createElement("input");
                    t.setAttribute("type", "hidden"), e.appendChild(t).setAttribute("name", "D"), e.querySelectorAll("[name=d]").length && M.push("name" + ot + "*[*^$|!~]?="), e.querySelectorAll(":enabled").length || M.push(":enabled", ":disabled"), e.querySelectorAll("*,:x"), M.push(",.*:")
                })), (_.matchesSelector = vt.test(H = L.webkitMatchesSelector || L.mozMatchesSelector || L.oMatchesSelector || L.msMatchesSelector)) && i(function(e) {
                    _.disconnectedMatch = H.call(e, "div"), H.call(e, "[s!='']:x"), I.push("!=", st)
                }), M = M.length && new RegExp(M.join("|")), I = I.length && new RegExp(I.join("|")), t = vt.test(L.compareDocumentPosition), P = t || vt.test(L.contains) ? function(e, t) {
                    var n = 9 === e.nodeType ? e.documentElement : e,
                        o = t && t.parentNode;
                    return e === o || !(!o || 1 !== o.nodeType || !(n.contains ? n.contains(o) : e.compareDocumentPosition && 16 & e.compareDocumentPosition(o)))
                } : function(e, t) {
                    if (t)
                        for (; t = t.parentNode;)
                            if (t === e) return !0;
                    return !1
                }, X = t ? function(e, t) {
                    if (e === t) return N = !0, 0;
                    var o = !e.compareDocumentPosition - !t.compareDocumentPosition;
                    return o ? o : (o = (e.ownerDocument || e) === (t.ownerDocument || t) ? e.compareDocumentPosition(t) : 1, 1 & o || !_.sortDetached && t.compareDocumentPosition(e) === o ? e === n || e.ownerDocument === B && P(B, e) ? -1 : t === n || t.ownerDocument === B && P(B, t) ? 1 : E ? tt.call(E, e) - tt.call(E, t) : 0 : 4 & o ? -1 : 1)
                } : function(e, t) {
                    if (e === t) return N = !0, 0;
                    var o, i = 0,
                        r = e.parentNode,
                        s = t.parentNode,
                        l = [e],
                        u = [t];
                    if (!r || !s) return e === n ? -1 : t === n ? 1 : r ? -1 : s ? 1 : E ? tt.call(E, e) - tt.call(E, t) : 0;
                    if (r === s) return a(e, t);
                    for (o = e; o = o.parentNode;) l.unshift(o);
                    for (o = t; o = o.parentNode;) u.unshift(o);
                    for (; l[i] === u[i];) i++;
                    return i ? a(l[i], u[i]) : l[i] === B ? -1 : u[i] === B ? 1 : 0
                }, n) : A
            }, t.matches = function(e, n) {
                return t(e, null, null, n)
            }, t.matchesSelector = function(e, n) {
                if ((e.ownerDocument || e) !== A && z(e), n = n.replace(dt, "='$1']"), !(!_.matchesSelector || !D || I && I.test(n) || M && M.test(n))) try {
                    var o = H.call(e, n);
                    if (o || _.disconnectedMatch || e.document && 11 !== e.document.nodeType) return o
                } catch (i) {}
                return t(n, A, null, [e]).length > 0
            }, t.contains = function(e, t) {
                return (e.ownerDocument || e) !== A && z(e), P(e, t)
            }, t.attr = function(e, t) {
                (e.ownerDocument || e) !== A && z(e);
                var n = C.attrHandle[t.toLowerCase()],
                    o = n && J.call(C.attrHandle, t.toLowerCase()) ? n(e, t, !D) : void 0;
                return void 0 !== o ? o : _.attributes || !D ? e.getAttribute(t) : (o = e.getAttributeNode(t)) && o.specified ? o.value : null
            }, t.error = function(e) {
                throw new Error("Syntax error, unrecognized expression: " + e)
            }, t.uniqueSort = function(e) {
                var t, n = [],
                    o = 0,
                    i = 0;
                if (N = !_.detectDuplicates, E = !_.sortStable && e.slice(0), e.sort(X), N) {
                    for (; t = e[i++];) t === e[i] && (o = n.push(i));
                    for (; o--;) e.splice(n[o], 1)
                }
                return E = null, e
            }, T = t.getText = function(e) {
                var t, n = "",
                    o = 0,
                    i = e.nodeType;
                if (i) {
                    if (1 === i || 9 === i || 11 === i) {
                        if ("string" == typeof e.textContent) return e.textContent;
                        for (e = e.firstChild; e; e = e.nextSibling) n += T(e)
                    } else if (3 === i || 4 === i) return e.nodeValue
                } else
                    for (; t = e[o++];) n += T(t);
                return n
            }, C = t.selectors = {
                cacheLength: 50,
                createPseudo: o,
                match: ht,
                attrHandle: {},
                find: {},
                relative: {
                    ">": {
                        dir: "parentNode",
                        first: !0
                    },
                    " ": {
                        dir: "parentNode"
                    },
                    "+": {
                        dir: "previousSibling",
                        first: !0
                    },
                    "~": {
                        dir: "previousSibling"
                    }
                },
                preFilter: {
                    ATTR: function(e) {
                        return e[1] = e[1].replace(kt, xt), e[3] = (e[4] || e[5] || "").replace(kt, xt), "~=" === e[2] && (e[3] = " " + e[3] + " "), e.slice(0, 4)
                    },
                    CHILD: function(e) {
                        return e[1] = e[1].toLowerCase(), "nth" === e[1].slice(0, 3) ? (e[3] || t.error(e[0]), e[4] = +(e[4] ? e[5] + (e[6] || 1) : 2 * ("even" === e[3] || "odd" === e[3])), e[5] = +(e[7] + e[8] || "odd" === e[3])) : e[3] && t.error(e[0]), e
                    },
                    PSEUDO: function(e) {
                        var t, n = !e[5] && e[2];
                        return ht.CHILD.test(e[0]) ? null : (e[3] && void 0 !== e[4] ? e[2] = e[4] : n && pt.test(n) && (t = p(n, !0)) && (t = n.indexOf(")", n.length - t) - n.length) && (e[0] = e[0].slice(0, t), e[2] = n.slice(0, t)), e.slice(0, 3))
                    }
                },
                filter: {
                    TAG: function(e) {
                        var t = e.replace(kt, xt).toLowerCase();
                        return "*" === e ? function() {
                            return !0
                        } : function(e) {
                            return e.nodeName && e.nodeName.toLowerCase() === t
                        }
                    },
                    CLASS: function(e) {
                        var t = R[e + " "];
                        return t || (t = new RegExp("(^|" + ot + ")" + e + "(" + ot + "|$)")) && R(e, function(e) {
                                return t.test("string" == typeof e.className && e.className || typeof e.getAttribute !== V && e.getAttribute("class") || "")
                            })
                    },
                    ATTR: function(e, n, o) {
                        return function(i) {
                            var r = t.attr(i, e);
                            return null == r ? "!=" === n : n ? (r += "", "=" === n ? r === o : "!=" === n ? r !== o : "^=" === n ? o && 0 === r.indexOf(o) : "*=" === n ? o && r.indexOf(o) > -1 : "$=" === n ? o && r.slice(-o.length) === o : "~=" === n ? (" " + r + " ").indexOf(o) > -1 : "|=" === n ? r === o || r.slice(0, o.length + 1) === o + "-" : !1) : !0
                        }
                    },
                    CHILD: function(e, t, n, o, i) {
                        var r = "nth" !== e.slice(0, 3),
                            a = "last" !== e.slice(-4),
                            s = "of-type" === t;
                        return 1 === o && 0 === i ? function(e) {
                            return !!e.parentNode
                        } : function(t, n, l) {
                            var u, c, d, p, f, h, m = r !== a ? "nextSibling" : "previousSibling",
                                g = t.parentNode,
                                v = s && t.nodeName.toLowerCase(),
                                y = !l && !s;
                            if (g) {
                                if (r) {
                                    for (; m;) {
                                        for (d = t; d = d[m];)
                                            if (s ? d.nodeName.toLowerCase() === v : 1 === d.nodeType) return !1;
                                        h = m = "only" === e && !h && "nextSibling"
                                    }
                                    return !0
                                }
                                if (h = [a ? g.firstChild : g.lastChild], a && y) {
                                    for (c = g[O] || (g[O] = {}), u = c[e] || [], f = u[0] === F && u[1], p = u[0] === F && u[2], d = f && g.childNodes[f]; d = ++f && d && d[m] || (p = f = 0) || h.pop();)
                                        if (1 === d.nodeType && ++p && d === t) {
                                            c[e] = [F, f, p];
                                            break
                                        }
                                } else if (y && (u = (t[O] || (t[O] = {}))[e]) && u[0] === F) p = u[1];
                                else
                                    for (;
                                        (d = ++f && d && d[m] || (p = f = 0) || h.pop()) && ((s ? d.nodeName.toLowerCase() !== v : 1 !== d.nodeType) || !++p || (y && ((d[O] || (d[O] = {}))[e] = [F, p]), d !== t)););
                                return p -= i, p === o || p % o === 0 && p / o >= 0
                            }
                        }
                    },
                    PSEUDO: function(e, n) {
                        var i, r = C.pseudos[e] || C.setFilters[e.toLowerCase()] || t.error("unsupported pseudo: " + e);
                        return r[O] ? r(n) : r.length > 1 ? (i = [e, e, "", n], C.setFilters.hasOwnProperty(e.toLowerCase()) ? o(function(e, t) {
                            for (var o, i = r(e, n), a = i.length; a--;) o = tt.call(e, i[a]), e[o] = !(t[o] = i[a])
                        }) : function(e) {
                            return r(e, 0, i)
                        }) : r
                    }
                },
                pseudos: {
                    not: o(function(e) {
                        var t = [],
                            n = [],
                            i = S(e.replace(lt, "$1"));
                        return i[O] ? o(function(e, t, n, o) {
                            for (var r, a = i(e, null, o, []), s = e.length; s--;)(r = a[s]) && (e[s] = !(t[s] = r))
                        }) : function(e, o, r) {
                            return t[0] = e, i(t, null, r, n), !n.pop()
                        }
                    }),
                    has: o(function(e) {
                        return function(n) {
                            return t(e, n).length > 0
                        }
                    }),
                    contains: o(function(e) {
                        return function(t) {
                            return (t.textContent || t.innerText || T(t)).indexOf(e) > -1
                        }
                    }),
                    lang: o(function(e) {
                        return ft.test(e || "") || t.error("unsupported lang: " + e), e = e.replace(kt, xt).toLowerCase(),
                            function(t) {
                                var n;
                                do
                                    if (n = D ? t.lang : t.getAttribute("xml:lang") || t.getAttribute("lang")) return n = n.toLowerCase(), n === e || 0 === n.indexOf(e + "-");
                                while ((t = t.parentNode) && 1 === t.nodeType);
                                return !1
                            }
                    }),
                    target: function(t) {
                        var n = e.location && e.location.hash;
                        return n && n.slice(1) === t.id
                    },
                    root: function(e) {
                        return e === L
                    },
                    focus: function(e) {
                        return e === A.activeElement && (!A.hasFocus || A.hasFocus()) && !!(e.type || e.href || ~e.tabIndex)
                    },
                    enabled: function(e) {
                        return e.disabled === !1
                    },
                    disabled: function(e) {
                        return e.disabled === !0
                    },
                    checked: function(e) {
                        var t = e.nodeName.toLowerCase();
                        return "input" === t && !!e.checked || "option" === t && !!e.selected
                    },
                    selected: function(e) {
                        return e.parentNode && e.parentNode.selectedIndex, e.selected === !0
                    },
                    empty: function(e) {
                        for (e = e.firstChild; e; e = e.nextSibling)
                            if (e.nodeType < 6) return !1;
                        return !0
                    },
                    parent: function(e) {
                        return !C.pseudos.empty(e)
                    },
                    header: function(e) {
                        return gt.test(e.nodeName)
                    },
                    input: function(e) {
                        return mt.test(e.nodeName)
                    },
                    button: function(e) {
                        var t = e.nodeName.toLowerCase();
                        return "input" === t && "button" === e.type || "button" === t
                    },
                    text: function(e) {
                        var t;
                        return "input" === e.nodeName.toLowerCase() && "text" === e.type && (null == (t = e.getAttribute("type")) || "text" === t.toLowerCase())
                    },
                    first: u(function() {
                        return [0]
                    }),
                    last: u(function(e, t) {
                        return [t - 1]
                    }),
                    eq: u(function(e, t, n) {
                        return [0 > n ? n + t : n]
                    }),
                    even: u(function(e, t) {
                        for (var n = 0; t > n; n += 2) e.push(n);
                        return e
                    }),
                    odd: u(function(e, t) {
                        for (var n = 1; t > n; n += 2) e.push(n);
                        return e
                    }),
                    lt: u(function(e, t, n) {
                        for (var o = 0 > n ? n + t : n; --o >= 0;) e.push(o);
                        return e
                    }),
                    gt: u(function(e, t, n) {
                        for (var o = 0 > n ? n + t : n; ++o < t;) e.push(o);
                        return e
                    })
                }
            }, C.pseudos.nth = C.pseudos.eq;
            for (x in {
                radio: !0,
                checkbox: !0,
                file: !0,
                password: !0,
                image: !0
            }) C.pseudos[x] = s(x);
            for (x in {
                submit: !0,
                reset: !0
            }) C.pseudos[x] = l(x);
            return d.prototype = C.filters = C.pseudos, C.setFilters = new d, S = t.compile = function(e, t) {
                var n, o = [],
                    i = [],
                    r = Y[e + " "];
                if (!r) {
                    for (t || (t = p(e)), n = t.length; n--;) r = y(t[n]), r[O] ? o.push(r) : i.push(r);
                    r = Y(e, b(i, o))
                }
                return r
            }, _.sortStable = O.split("").sort(X).join("") === O, _.detectDuplicates = !!N, z(), _.sortDetached = i(function(e) {
                return 1 & e.compareDocumentPosition(A.createElement("div"))
            }), i(function(e) {
                return e.innerHTML = "<a href='#'></a>", "#" === e.firstChild.getAttribute("href")
            }) || r("type|href|height|width", function(e, t, n) {
                return n ? void 0 : e.getAttribute(t, "type" === t.toLowerCase() ? 1 : 2)
            }), _.attributes && i(function(e) {
                return e.innerHTML = "<input/>", e.firstChild.setAttribute("value", ""), "" === e.firstChild.getAttribute("value")
            }) || r("value", function(e, t, n) {
                return n || "input" !== e.nodeName.toLowerCase() ? void 0 : e.defaultValue
            }), i(function(e) {
                return null == e.getAttribute("disabled")
            }) || r(nt, function(e, t, n) {
                var o;
                return n ? void 0 : e[t] === !0 ? t.toLowerCase() : (o = e.getAttributeNode(t)) && o.specified ? o.value : null
            }), t
        }(e);
        rt.find = ct, rt.expr = ct.selectors, rt.expr[":"] = rt.expr.pseudos, rt.unique = ct.uniqueSort, rt.text = ct.getText, rt.isXMLDoc = ct.isXML, rt.contains = ct.contains;
        var dt = rt.expr.match.needsContext,
            pt = /^<(\w+)\s*\/?>(?:<\/\1>|)$/,
            ft = /^.[^:#\[\.,]*$/;
        rt.filter = function(e, t, n) {
            var o = t[0];
            return n && (e = ":not(" + e + ")"), 1 === t.length && 1 === o.nodeType ? rt.find.matchesSelector(o, e) ? [o] : [] : rt.find.matches(e, rt.grep(t, function(e) {
                return 1 === e.nodeType
            }))
        }, rt.fn.extend({
            find: function(e) {
                var t, n = [],
                    o = this,
                    i = o.length;
                if ("string" != typeof e) return this.pushStack(rt(e).filter(function() {
                    for (t = 0; i > t; t++)
                        if (rt.contains(o[t], this)) return !0
                }));
                for (t = 0; i > t; t++) rt.find(e, o[t], n);
                return n = this.pushStack(i > 1 ? rt.unique(n) : n), n.selector = this.selector ? this.selector + " " + e : e, n
            },
            filter: function(e) {
                return this.pushStack(o(this, e || [], !1))
            },
            not: function(e) {
                return this.pushStack(o(this, e || [], !0))
            },
            is: function(e) {
                return !!o(this, "string" == typeof e && dt.test(e) ? rt(e) : e || [], !1).length
            }
        });
        var ht, mt = e.document,
            gt = /^(?:\s*(<[\w\W]+>)[^>]*|#([\w-]*))$/,
            vt = rt.fn.init = function(e, t) {
                var n, o;
                if (!e) return this;
                if ("string" == typeof e) {
                    if (n = "<" === e.charAt(0) && ">" === e.charAt(e.length - 1) && e.length >= 3 ? [null, e, null] : gt.exec(e), !n || !n[1] && t) return !t || t.jquery ? (t || ht).find(e) : this.constructor(t).find(e);
                    if (n[1]) {
                        if (t = t instanceof rt ? t[0] : t, rt.merge(this, rt.parseHTML(n[1], t && t.nodeType ? t.ownerDocument || t : mt, !0)), pt.test(n[1]) && rt.isPlainObject(t))
                            for (n in t) rt.isFunction(this[n]) ? this[n](t[n]) : this.attr(n, t[n]);
                        return this
                    }
                    if (o = mt.getElementById(n[2]), o && o.parentNode) {
                        if (o.id !== n[2]) return ht.find(e);
                        this.length = 1, this[0] = o
                    }
                    return this.context = mt, this.selector = e, this
                }
                return e.nodeType ? (this.context = this[0] = e, this.length = 1, this) : rt.isFunction(e) ? "undefined" != typeof ht.ready ? ht.ready(e) : e(rt) : (void 0 !== e.selector && (this.selector = e.selector, this.context = e.context), rt.makeArray(e, this))
            };
        vt.prototype = rt.fn, ht = rt(mt);
        var yt = /^(?:parents|prev(?:Until|All))/,
            bt = {
                children: !0,
                contents: !0,
                next: !0,
                prev: !0
            };
        rt.extend({
            dir: function(e, t, n) {
                for (var o = [], i = e[t]; i && 9 !== i.nodeType && (void 0 === n || 1 !== i.nodeType || !rt(i).is(n));) 1 === i.nodeType && o.push(i), i = i[t];
                return o
            },
            sibling: function(e, t) {
                for (var n = []; e; e = e.nextSibling) 1 === e.nodeType && e !== t && n.push(e);
                return n
            }
        }), rt.fn.extend({
            has: function(e) {
                var t, n = rt(e, this),
                    o = n.length;
                return this.filter(function() {
                    for (t = 0; o > t; t++)
                        if (rt.contains(this, n[t])) return !0
                })
            },
            closest: function(e, t) {
                for (var n, o = 0, i = this.length, r = [], a = dt.test(e) || "string" != typeof e ? rt(e, t || this.context) : 0; i > o; o++)
                    for (n = this[o]; n && n !== t; n = n.parentNode)
                        if (n.nodeType < 11 && (a ? a.index(n) > -1 : 1 === n.nodeType && rt.find.matchesSelector(n, e))) {
                            r.push(n);
                            break
                        }
                return this.pushStack(r.length > 1 ? rt.unique(r) : r)
            },
            index: function(e) {
                return e ? "string" == typeof e ? rt.inArray(this[0], rt(e)) : rt.inArray(e.jquery ? e[0] : e, this) : this[0] && this[0].parentNode ? this.first().prevAll().length : -1
            },
            add: function(e, t) {
                return this.pushStack(rt.unique(rt.merge(this.get(), rt(e, t))))
            },
            addBack: function(e) {
                return this.add(null == e ? this.prevObject : this.prevObject.filter(e))
            }
        }), rt.each({
            parent: function(e) {
                var t = e.parentNode;
                return t && 11 !== t.nodeType ? t : null
            },
            parents: function(e) {
                return rt.dir(e, "parentNode")
            },
            parentsUntil: function(e, t, n) {
                return rt.dir(e, "parentNode", n)
            },
            next: function(e) {
                return i(e, "nextSibling")
            },
            prev: function(e) {
                return i(e, "previousSibling")
            },
            nextAll: function(e) {
                return rt.dir(e, "nextSibling")
            },
            prevAll: function(e) {
                return rt.dir(e, "previousSibling")
            },
            nextUntil: function(e, t, n) {
                return rt.dir(e, "nextSibling", n)
            },
            prevUntil: function(e, t, n) {
                return rt.dir(e, "previousSibling", n)
            },
            siblings: function(e) {
                return rt.sibling((e.parentNode || {}).firstChild, e)
            },
            children: function(e) {
                return rt.sibling(e.firstChild)
            },
            contents: function(e) {
                return rt.nodeName(e, "iframe") ? e.contentDocument || e.contentWindow.document : rt.merge([], e.childNodes)
            }
        }, function(e, t) {
            rt.fn[e] = function(n, o) {
                var i = rt.map(this, t, n);
                return "Until" !== e.slice(-5) && (o = n), o && "string" == typeof o && (i = rt.filter(o, i)), this.length > 1 && (bt[e] || (i = rt.unique(i)), yt.test(e) && (i = i.reverse())), this.pushStack(i)
            }
        });
        var wt = /\S+/g,
            kt = {};
        rt.Callbacks = function(e) {
            e = "string" == typeof e ? kt[e] || r(e) : rt.extend({}, e);
            var t, n, o, i, a, s, l = [],
                u = !e.once && [],
                c = function(r) {
                    for (n = e.memory && r, o = !0, a = s || 0, s = 0, i = l.length, t = !0; l && i > a; a++)
                        if (l[a].apply(r[0], r[1]) === !1 && e.stopOnFalse) {
                            n = !1;
                            break
                        }
                    t = !1, l && (u ? u.length && c(u.shift()) : n ? l = [] : d.disable())
                },
                d = {
                    add: function() {
                        if (l) {
                            var o = l.length;
                            ! function r(t) {
                                rt.each(t, function(t, n) {
                                    var o = rt.type(n);
                                    "function" === o ? e.unique && d.has(n) || l.push(n) : n && n.length && "string" !== o && r(n)
                                })
                            }(arguments), t ? i = l.length : n && (s = o, c(n))
                        }
                        return this
                    },
                    remove: function() {
                        return l && rt.each(arguments, function(e, n) {
                            for (var o;
                                 (o = rt.inArray(n, l, o)) > -1;) l.splice(o, 1), t && (i >= o && i--, a >= o && a--)
                        }), this
                    },
                    has: function(e) {
                        return e ? rt.inArray(e, l) > -1 : !(!l || !l.length)
                    },
                    empty: function() {
                        return l = [], i = 0, this
                    },
                    disable: function() {
                        return l = u = n = void 0, this
                    },
                    disabled: function() {
                        return !l
                    },
                    lock: function() {
                        return u = void 0, n || d.disable(), this
                    },
                    locked: function() {
                        return !u
                    },
                    fireWith: function(e, n) {
                        return !l || o && !u || (n = n || [], n = [e, n.slice ? n.slice() : n], t ? u.push(n) : c(n)), this
                    },
                    fire: function() {
                        return d.fireWith(this, arguments), this
                    },
                    fired: function() {
                        return !!o
                    }
                };
            return d
        }, rt.extend({
            Deferred: function(e) {
                var t = [
                        ["resolve", "done", rt.Callbacks("once memory"), "resolved"],
                        ["reject", "fail", rt.Callbacks("once memory"), "rejected"],
                        ["notify", "progress", rt.Callbacks("memory")]
                    ],
                    n = "pending",
                    o = {
                        state: function() {
                            return n
                        },
                        always: function() {
                            return i.done(arguments).fail(arguments), this
                        },
                        then: function() {
                            var e = arguments;
                            return rt.Deferred(function(n) {
                                rt.each(t, function(t, r) {
                                    var a = rt.isFunction(e[t]) && e[t];
                                    i[r[1]](function() {
                                        var e = a && a.apply(this, arguments);
                                        e && rt.isFunction(e.promise) ? e.promise().done(n.resolve).fail(n.reject).progress(n.notify) : n[r[0] + "With"](this === o ? n.promise() : this, a ? [e] : arguments)
                                    })
                                }), e = null
                            }).promise()
                        },
                        promise: function(e) {
                            return null != e ? rt.extend(e, o) : o
                        }
                    },
                    i = {};
                return o.pipe = o.then, rt.each(t, function(e, r) {
                    var a = r[2],
                        s = r[3];
                    o[r[1]] = a.add, s && a.add(function() {
                        n = s
                    }, t[1 ^ e][2].disable, t[2][2].lock), i[r[0]] = function() {
                        return i[r[0] + "With"](this === i ? o : this, arguments), this
                    }, i[r[0] + "With"] = a.fireWith
                }), o.promise(i), e && e.call(i, i), i
            },
            when: function(e) {
                var t, n, o, i = 0,
                    r = J.call(arguments),
                    a = r.length,
                    s = 1 !== a || e && rt.isFunction(e.promise) ? a : 0,
                    l = 1 === s ? e : rt.Deferred(),
                    u = function(e, n, o) {
                        return function(i) {
                            n[e] = this, o[e] = arguments.length > 1 ? J.call(arguments) : i, o === t ? l.notifyWith(n, o) : --s || l.resolveWith(n, o)
                        }
                    };
                if (a > 1)
                    for (t = new Array(a), n = new Array(a), o = new Array(a); a > i; i++) r[i] && rt.isFunction(r[i].promise) ? r[i].promise().done(u(i, o, r)).fail(l.reject).progress(u(i, n, t)) : --s;
                return s || l.resolveWith(o, r), l.promise()
            }
        });
        var xt;
        rt.fn.ready = function(e) {
            return rt.ready.promise().done(e), this
        }, rt.extend({
            isReady: !1,
            readyWait: 1,
            holdReady: function(e) {
                e ? rt.readyWait++ : rt.ready(!0)
            },
            ready: function(e) {
                if (e === !0 ? !--rt.readyWait : !rt.isReady) {
                    if (!mt.body) return setTimeout(rt.ready);
                    rt.isReady = !0, e !== !0 && --rt.readyWait > 0 || (xt.resolveWith(mt, [rt]), rt.fn.trigger && rt(mt).trigger("ready").off("ready"))
                }
            }
        }), rt.ready.promise = function(t) {
            if (!xt)
                if (xt = rt.Deferred(), "complete" === mt.readyState) setTimeout(rt.ready);
                else if (mt.addEventListener) mt.addEventListener("DOMContentLoaded", s, !1), e.addEventListener("load", s, !1);
                else {
                    mt.attachEvent("onreadystatechange", s), e.attachEvent("onload", s);
                    var n = !1;
                    try {
                        n = null == e.frameElement && mt.documentElement
                    } catch (o) {}
                    n && n.doScroll && ! function i() {
                        if (!rt.isReady) {
                            try {
                                n.doScroll("left")
                            } catch (e) {
                                return setTimeout(i, 50)
                            }
                            a(), rt.ready()
                        }
                    }()
                }
            return xt.promise(t)
        };
        var _t, Ct = "undefined";
        for (_t in rt(ot)) break;
        ot.ownLast = "0" !== _t, ot.inlineBlockNeedsLayout = !1, rt(function() {
            var e, t, n = mt.getElementsByTagName("body")[0];
            n && (e = mt.createElement("div"), e.style.cssText = "border:0;width:0;height:0;position:absolute;top:0;left:-9999px;margin-top:1px", t = mt.createElement("div"), n.appendChild(e).appendChild(t), typeof t.style.zoom !== Ct && (t.style.cssText = "border:0;margin:0;width:1px;padding:1px;display:inline;zoom:1", (ot.inlineBlockNeedsLayout = 3 === t.offsetWidth) && (n.style.zoom = 1)), n.removeChild(e), e = t = null)
        }),
            function() {
                var e = mt.createElement("div");
                if (null == ot.deleteExpando) {
                    ot.deleteExpando = !0;
                    try {
                        delete e.test
                    } catch (t) {
                        ot.deleteExpando = !1
                    }
                }
                e = null
            }(), rt.acceptData = function(e) {
            var t = rt.noData[(e.nodeName + " ").toLowerCase()],
                n = +e.nodeType || 1;
            return 1 !== n && 9 !== n ? !1 : !t || t !== !0 && e.getAttribute("classid") === t
        };
        var Tt = /^(?:\{[\w\W]*\}|\[[\w\W]*\])$/,
            jt = /([A-Z])/g;
        rt.extend({
            cache: {},
            noData: {
                "applet ": !0,
                "embed ": !0,
                "object ": "clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
            },
            hasData: function(e) {
                return e = e.nodeType ? rt.cache[e[rt.expando]] : e[rt.expando], !!e && !u(e)
            },
            data: function(e, t, n) {
                return c(e, t, n)
            },
            removeData: function(e, t) {
                return d(e, t)
            },
            _data: function(e, t, n) {
                return c(e, t, n, !0)
            },
            _removeData: function(e, t) {
                return d(e, t, !0)
            }
        }), rt.fn.extend({
            data: function(e, t) {
                var n, o, i, r = this[0],
                    a = r && r.attributes;
                if (void 0 === e) {
                    if (this.length && (i = rt.data(r), 1 === r.nodeType && !rt._data(r, "parsedAttrs"))) {
                        for (n = a.length; n--;) o = a[n].name, 0 === o.indexOf("data-") && (o = rt.camelCase(o.slice(5)), l(r, o, i[o]));
                        rt._data(r, "parsedAttrs", !0)
                    }
                    return i
                }
                return "object" == typeof e ? this.each(function() {
                    rt.data(this, e)
                }) : arguments.length > 1 ? this.each(function() {
                    rt.data(this, e, t)
                }) : r ? l(r, e, rt.data(r, e)) : void 0
            },
            removeData: function(e) {
                return this.each(function() {
                    rt.removeData(this, e)
                })
            }
        }), rt.extend({
            queue: function(e, t, n) {
                var o;
                return e ? (t = (t || "fx") + "queue", o = rt._data(e, t), n && (!o || rt.isArray(n) ? o = rt._data(e, t, rt.makeArray(n)) : o.push(n)), o || []) : void 0
            },
            dequeue: function(e, t) {
                t = t || "fx";
                var n = rt.queue(e, t),
                    o = n.length,
                    i = n.shift(),
                    r = rt._queueHooks(e, t),
                    a = function() {
                        rt.dequeue(e, t)
                    };
                "inprogress" === i && (i = n.shift(), o--), i && ("fx" === t && n.unshift("inprogress"), delete r.stop, i.call(e, a, r)), !o && r && r.empty.fire()
            },
            _queueHooks: function(e, t) {
                var n = t + "queueHooks";
                return rt._data(e, n) || rt._data(e, n, {
                        empty: rt.Callbacks("once memory").add(function() {
                            rt._removeData(e, t + "queue"), rt._removeData(e, n)
                        })
                    })
            }
        }), rt.fn.extend({
            queue: function(e, t) {
                var n = 2;
                return "string" != typeof e && (t = e, e = "fx", n--), arguments.length < n ? rt.queue(this[0], e) : void 0 === t ? this : this.each(function() {
                    var n = rt.queue(this, e, t);
                    rt._queueHooks(this, e), "fx" === e && "inprogress" !== n[0] && rt.dequeue(this, e)
                })
            },
            dequeue: function(e) {
                return this.each(function() {
                    rt.dequeue(this, e)
                })
            },
            clearQueue: function(e) {
                return this.queue(e || "fx", [])
            },
            promise: function(e, t) {
                var n, o = 1,
                    i = rt.Deferred(),
                    r = this,
                    a = this.length,
                    s = function() {
                        --o || i.resolveWith(r, [r])
                    };
                for ("string" != typeof e && (t = e, e = void 0), e = e || "fx"; a--;) n = rt._data(r[a], e + "queueHooks"), n && n.empty && (o++, n.empty.add(s));
                return s(), i.promise(t)
            }
        });
        var St = /[+-]?(?:\d*\.|)\d+(?:[eE][+-]?\d+|)/.source,
            $t = ["Top", "Right", "Bottom", "Left"],
            Et = function(e, t) {
                return e = t || e, "none" === rt.css(e, "display") || !rt.contains(e.ownerDocument, e)
            },
            Nt = rt.access = function(e, t, n, o, i, r, a) {
                var s = 0,
                    l = e.length,
                    u = null == n;
                if ("object" === rt.type(n)) {
                    i = !0;
                    for (s in n) rt.access(e, t, s, n[s], !0, r, a)
                } else if (void 0 !== o && (i = !0, rt.isFunction(o) || (a = !0), u && (a ? (t.call(e, o), t = null) : (u = t, t = function(e, t, n) {
                        return u.call(rt(e), n)
                    })), t))
                    for (; l > s; s++) t(e[s], n, a ? o : o.call(e[s], s, t(e[s], n)));
                return i ? e : u ? t.call(e) : l ? t(e[0], n) : r
            },
            zt = /^(?:checkbox|radio)$/i;
        ! function() {
            var e = mt.createDocumentFragment(),
                t = mt.createElement("div"),
                n = mt.createElement("input");
            if (t.setAttribute("className", "t"), t.innerHTML = "  <link/><table></table><a href='/a'>a</a>", ot.leadingWhitespace = 3 === t.firstChild.nodeType, ot.tbody = !t.getElementsByTagName("tbody").length, ot.htmlSerialize = !!t.getElementsByTagName("link").length, ot.html5Clone = "<:nav></:nav>" !== mt.createElement("nav").cloneNode(!0).outerHTML, n.type = "checkbox", n.checked = !0, e.appendChild(n), ot.appendChecked = n.checked, t.innerHTML = "<textarea>x</textarea>", ot.noCloneChecked = !!t.cloneNode(!0).lastChild.defaultValue, e.appendChild(t), t.innerHTML = "<input type='radio' checked='checked' name='t'/>", ot.checkClone = t.cloneNode(!0).cloneNode(!0).lastChild.checked, ot.noCloneEvent = !0, t.attachEvent && (t.attachEvent("onclick", function() {
                    ot.noCloneEvent = !1
                }), t.cloneNode(!0).click()), null == ot.deleteExpando) {
                ot.deleteExpando = !0;
                try {
                    delete t.test
                } catch (o) {
                    ot.deleteExpando = !1
                }
            }
            e = t = n = null
        }(),
            function() {
                var t, n, o = mt.createElement("div");
                for (t in {
                    submit: !0,
                    change: !0,
                    focusin: !0
                }) n = "on" + t, (ot[t + "Bubbles"] = n in e) || (o.setAttribute(n, "t"), ot[t + "Bubbles"] = o.attributes[n].expando === !1);
                o = null
            }();
        var At = /^(?:input|select|textarea)$/i,
            Lt = /^key/,
            Dt = /^(?:mouse|contextmenu)|click/,
            Mt = /^(?:focusinfocus|focusoutblur)$/,
            It = /^([^.]*)(?:\.(.+)|)$/;
        rt.event = {
            global: {},
            add: function(e, t, n, o, i) {
                var r, a, s, l, u, c, d, p, f, h, m, g = rt._data(e);
                if (g) {
                    for (n.handler && (l = n, n = l.handler, i = l.selector), n.guid || (n.guid = rt.guid++), (a = g.events) || (a = g.events = {}), (c = g.handle) || (c = g.handle = function(e) {
                        return typeof rt === Ct || e && rt.event.triggered === e.type ? void 0 : rt.event.dispatch.apply(c.elem, arguments)
                    }, c.elem = e), t = (t || "").match(wt) || [""], s = t.length; s--;) r = It.exec(t[s]) || [], f = m = r[1], h = (r[2] || "").split(".").sort(), f && (u = rt.event.special[f] || {}, f = (i ? u.delegateType : u.bindType) || f, u = rt.event.special[f] || {}, d = rt.extend({
                        type: f,
                        origType: m,
                        data: o,
                        handler: n,
                        guid: n.guid,
                        selector: i,
                        needsContext: i && rt.expr.match.needsContext.test(i),
                        namespace: h.join(".")
                    }, l), (p = a[f]) || (p = a[f] = [], p.delegateCount = 0, u.setup && u.setup.call(e, o, h, c) !== !1 || (e.addEventListener ? e.addEventListener(f, c, !1) : e.attachEvent && e.attachEvent("on" + f, c))), u.add && (u.add.call(e, d), d.handler.guid || (d.handler.guid = n.guid)), i ? p.splice(p.delegateCount++, 0, d) : p.push(d), rt.event.global[f] = !0);
                    e = null
                }
            },
            remove: function(e, t, n, o, i) {
                var r, a, s, l, u, c, d, p, f, h, m, g = rt.hasData(e) && rt._data(e);
                if (g && (c = g.events)) {
                    for (t = (t || "").match(wt) || [""], u = t.length; u--;)
                        if (s = It.exec(t[u]) || [], f = m = s[1], h = (s[2] || "").split(".").sort(), f) {
                            for (d = rt.event.special[f] || {}, f = (o ? d.delegateType : d.bindType) || f, p = c[f] || [], s = s[2] && new RegExp("(^|\\.)" + h.join("\\.(?:.*\\.|)") + "(\\.|$)"), l = r = p.length; r--;) a = p[r], !i && m !== a.origType || n && n.guid !== a.guid || s && !s.test(a.namespace) || o && o !== a.selector && ("**" !== o || !a.selector) || (p.splice(r, 1), a.selector && p.delegateCount--, d.remove && d.remove.call(e, a));
                            l && !p.length && (d.teardown && d.teardown.call(e, h, g.handle) !== !1 || rt.removeEvent(e, f, g.handle), delete c[f])
                        } else
                            for (f in c) rt.event.remove(e, f + t[u], n, o, !0);
                    rt.isEmptyObject(c) && (delete g.handle, rt._removeData(e, "events"))
                }
            },
            trigger: function(t, n, o, i) {
                var r, a, s, l, u, c, d, p = [o || mt],
                    f = tt.call(t, "type") ? t.type : t,
                    h = tt.call(t, "namespace") ? t.namespace.split(".") : [];
                if (s = c = o = o || mt, 3 !== o.nodeType && 8 !== o.nodeType && !Mt.test(f + rt.event.triggered) && (f.indexOf(".") >= 0 && (h = f.split("."), f = h.shift(), h.sort()), a = f.indexOf(":") < 0 && "on" + f, t = t[rt.expando] ? t : new rt.Event(f, "object" == typeof t && t), t.isTrigger = i ? 2 : 3, t.namespace = h.join("."), t.namespace_re = t.namespace ? new RegExp("(^|\\.)" + h.join("\\.(?:.*\\.|)") + "(\\.|$)") : null, t.result = void 0, t.target || (t.target = o), n = null == n ? [t] : rt.makeArray(n, [t]), u = rt.event.special[f] || {}, i || !u.trigger || u.trigger.apply(o, n) !== !1)) {
                    if (!i && !u.noBubble && !rt.isWindow(o)) {
                        for (l = u.delegateType || f, Mt.test(l + f) || (s = s.parentNode); s; s = s.parentNode) p.push(s), c = s;
                        c === (o.ownerDocument || mt) && p.push(c.defaultView || c.parentWindow || e)
                    }
                    for (d = 0;
                         (s = p[d++]) && !t.isPropagationStopped();) t.type = d > 1 ? l : u.bindType || f, r = (rt._data(s, "events") || {})[t.type] && rt._data(s, "handle"), r && r.apply(s, n), r = a && s[a], r && r.apply && rt.acceptData(s) && (t.result = r.apply(s, n), t.result === !1 && t.preventDefault());
                    if (t.type = f, !i && !t.isDefaultPrevented() && (!u._default || u._default.apply(p.pop(), n) === !1) && rt.acceptData(o) && a && o[f] && !rt.isWindow(o)) {
                        c = o[a], c && (o[a] = null), rt.event.triggered = f;
                        try {
                            o[f]()
                        } catch (m) {}
                        rt.event.triggered = void 0, c && (o[a] = c)
                    }
                    return t.result
                }
            },
            dispatch: function(e) {
                e = rt.event.fix(e);
                var t, n, o, i, r, a = [],
                    s = J.call(arguments),
                    l = (rt._data(this, "events") || {})[e.type] || [],
                    u = rt.event.special[e.type] || {};
                if (s[0] = e, e.delegateTarget = this, !u.preDispatch || u.preDispatch.call(this, e) !== !1) {
                    for (a = rt.event.handlers.call(this, e, l), t = 0;
                         (i = a[t++]) && !e.isPropagationStopped();)
                        for (e.currentTarget = i.elem, r = 0;
                             (o = i.handlers[r++]) && !e.isImmediatePropagationStopped();)(!e.namespace_re || e.namespace_re.test(o.namespace)) && (e.handleObj = o, e.data = o.data, n = ((rt.event.special[o.origType] || {}).handle || o.handler).apply(i.elem, s), void 0 !== n && (e.result = n) === !1 && (e.preventDefault(), e.stopPropagation()));
                    return u.postDispatch && u.postDispatch.call(this, e), e.result
                }
            },
            handlers: function(e, t) {
                var n, o, i, r, a = [],
                    s = t.delegateCount,
                    l = e.target;
                if (s && l.nodeType && (!e.button || "click" !== e.type))
                    for (; l != this; l = l.parentNode || this)
                        if (1 === l.nodeType && (l.disabled !== !0 || "click" !== e.type)) {
                            for (i = [], r = 0; s > r; r++) o = t[r], n = o.selector + " ", void 0 === i[n] && (i[n] = o.needsContext ? rt(n, this).index(l) >= 0 : rt.find(n, this, null, [l]).length), i[n] && i.push(o);
                            i.length && a.push({
                                elem: l,
                                handlers: i
                            })
                        }
                return s < t.length && a.push({
                    elem: this,
                    handlers: t.slice(s)
                }), a
            },
            fix: function(e) {
                if (e[rt.expando]) return e;
                var t, n, o, i = e.type,
                    r = e,
                    a = this.fixHooks[i];
                for (a || (this.fixHooks[i] = a = Dt.test(i) ? this.mouseHooks : Lt.test(i) ? this.keyHooks : {}), o = a.props ? this.props.concat(a.props) : this.props, e = new rt.Event(r), t = o.length; t--;) n = o[t], e[n] = r[n];
                return e.target || (e.target = r.srcElement || mt), 3 === e.target.nodeType && (e.target = e.target.parentNode), e.metaKey = !!e.metaKey, a.filter ? a.filter(e, r) : e
            },
            props: "altKey bubbles cancelable ctrlKey currentTarget eventPhase metaKey relatedTarget shiftKey target timeStamp view which".split(" "),
            fixHooks: {},
            keyHooks: {
                props: "char charCode key keyCode".split(" "),
                filter: function(e, t) {
                    return null == e.which && (e.which = null != t.charCode ? t.charCode : t.keyCode), e
                }
            },
            mouseHooks: {
                props: "button buttons clientX clientY fromElement offsetX offsetY pageX pageY screenX screenY toElement".split(" "),
                filter: function(e, t) {
                    var n, o, i, r = t.button,
                        a = t.fromElement;
                    return null == e.pageX && null != t.clientX && (o = e.target.ownerDocument || mt, i = o.documentElement, n = o.body, e.pageX = t.clientX + (i && i.scrollLeft || n && n.scrollLeft || 0) - (i && i.clientLeft || n && n.clientLeft || 0), e.pageY = t.clientY + (i && i.scrollTop || n && n.scrollTop || 0) - (i && i.clientTop || n && n.clientTop || 0)), !e.relatedTarget && a && (e.relatedTarget = a === e.target ? t.toElement : a), e.which || void 0 === r || (e.which = 1 & r ? 1 : 2 & r ? 3 : 4 & r ? 2 : 0), e
                }
            },
            special: {
                load: {
                    noBubble: !0
                },
                focus: {
                    trigger: function() {
                        if (this !== h() && this.focus) try {
                            return this.focus(), !1
                        } catch (e) {}
                    },
                    delegateType: "focusin"
                },
                blur: {
                    trigger: function() {
                        return this === h() && this.blur ? (this.blur(), !1) : void 0
                    },
                    delegateType: "focusout"
                },
                click: {
                    trigger: function() {
                        return rt.nodeName(this, "input") && "checkbox" === this.type && this.click ? (this.click(), !1) : void 0
                    },
                    _default: function(e) {
                        return rt.nodeName(e.target, "a")
                    }
                },
                beforeunload: {
                    postDispatch: function(e) {
                        void 0 !== e.result && (e.originalEvent.returnValue = e.result)
                    }
                }
            },
            simulate: function(e, t, n, o) {
                var i = rt.extend(new rt.Event, n, {
                    type: e,
                    isSimulated: !0,
                    originalEvent: {}
                });
                o ? rt.event.trigger(i, null, t) : rt.event.dispatch.call(t, i), i.isDefaultPrevented() && n.preventDefault()
            }
        }, rt.removeEvent = mt.removeEventListener ? function(e, t, n) {
            e.removeEventListener && e.removeEventListener(t, n, !1)
        } : function(e, t, n) {
            var o = "on" + t;
            e.detachEvent && (typeof e[o] === Ct && (e[o] = null), e.detachEvent(o, n))
        }, rt.Event = function(e, t) {
            return this instanceof rt.Event ? (e && e.type ? (this.originalEvent = e, this.type = e.type, this.isDefaultPrevented = e.defaultPrevented || void 0 === e.defaultPrevented && (e.returnValue === !1 || e.getPreventDefault && e.getPreventDefault()) ? p : f) : this.type = e, t && rt.extend(this, t), this.timeStamp = e && e.timeStamp || rt.now(), this[rt.expando] = !0, void 0) : new rt.Event(e, t)
        }, rt.Event.prototype = {
            isDefaultPrevented: f,
            isPropagationStopped: f,
            isImmediatePropagationStopped: f,
            preventDefault: function() {
                var e = this.originalEvent;
                this.isDefaultPrevented = p, e && (e.preventDefault ? e.preventDefault() : e.returnValue = !1)
            },
            stopPropagation: function() {
                var e = this.originalEvent;
                this.isPropagationStopped = p, e && (e.stopPropagation && e.stopPropagation(), e.cancelBubble = !0)
            },
            stopImmediatePropagation: function() {
                this.isImmediatePropagationStopped = p, this.stopPropagation()
            }
        }, rt.each({
            mouseenter: "mouseover",
            mouseleave: "mouseout"
        }, function(e, t) {
            rt.event.special[e] = {
                delegateType: t,
                bindType: t,
                handle: function(e) {
                    var n, o = this,
                        i = e.relatedTarget,
                        r = e.handleObj;
                    return (!i || i !== o && !rt.contains(o, i)) && (e.type = r.origType, n = r.handler.apply(this, arguments), e.type = t), n
                }
            }
        }), ot.submitBubbles || (rt.event.special.submit = {
            setup: function() {
                return rt.nodeName(this, "form") ? !1 : (rt.event.add(this, "click._submit keypress._submit", function(e) {
                    var t = e.target,
                        n = rt.nodeName(t, "input") || rt.nodeName(t, "button") ? t.form : void 0;
                    n && !rt._data(n, "submitBubbles") && (rt.event.add(n, "submit._submit", function(e) {
                        e._submit_bubble = !0
                    }), rt._data(n, "submitBubbles", !0))
                }), void 0)
            },
            postDispatch: function(e) {
                e._submit_bubble && (delete e._submit_bubble, this.parentNode && !e.isTrigger && rt.event.simulate("submit", this.parentNode, e, !0))
            },
            teardown: function() {
                return rt.nodeName(this, "form") ? !1 : (rt.event.remove(this, "._submit"), void 0)
            }
        }), ot.changeBubbles || (rt.event.special.change = {
            setup: function() {
                return At.test(this.nodeName) ? (("checkbox" === this.type || "radio" === this.type) && (rt.event.add(this, "propertychange._change", function(e) {
                    "checked" === e.originalEvent.propertyName && (this._just_changed = !0)
                }), rt.event.add(this, "click._change", function(e) {
                    this._just_changed && !e.isTrigger && (this._just_changed = !1), rt.event.simulate("change", this, e, !0)
                })), !1) : (rt.event.add(this, "beforeactivate._change", function(e) {
                    var t = e.target;
                    At.test(t.nodeName) && !rt._data(t, "changeBubbles") && (rt.event.add(t, "change._change", function(e) {
                        !this.parentNode || e.isSimulated || e.isTrigger || rt.event.simulate("change", this.parentNode, e, !0)
                    }), rt._data(t, "changeBubbles", !0))
                }), void 0)
            },
            handle: function(e) {
                var t = e.target;
                return this !== t || e.isSimulated || e.isTrigger || "radio" !== t.type && "checkbox" !== t.type ? e.handleObj.handler.apply(this, arguments) : void 0
            },
            teardown: function() {
                return rt.event.remove(this, "._change"), !At.test(this.nodeName)
            }
        }), ot.focusinBubbles || rt.each({
            focus: "focusin",
            blur: "focusout"
        }, function(e, t) {
            var n = function(e) {
                rt.event.simulate(t, e.target, rt.event.fix(e), !0)
            };
            rt.event.special[t] = {
                setup: function() {
                    var o = this.ownerDocument || this,
                        i = rt._data(o, t);
                    i || o.addEventListener(e, n, !0), rt._data(o, t, (i || 0) + 1)
                },
                teardown: function() {
                    var o = this.ownerDocument || this,
                        i = rt._data(o, t) - 1;
                    i ? rt._data(o, t, i) : (o.removeEventListener(e, n, !0), rt._removeData(o, t))
                }
            }
        }), rt.fn.extend({
            on: function(e, t, n, o, i) {
                var r, a;
                if ("object" == typeof e) {
                    "string" != typeof t && (n = n || t, t = void 0);
                    for (r in e) this.on(r, t, n, e[r], i);
                    return this
                }
                if (null == n && null == o ? (o = t, n = t = void 0) : null == o && ("string" == typeof t ? (o = n, n = void 0) : (o = n, n = t, t = void 0)), o === !1) o = f;
                else if (!o) return this;
                return 1 === i && (a = o, o = function(e) {
                    return rt().off(e), a.apply(this, arguments)
                }, o.guid = a.guid || (a.guid = rt.guid++)), this.each(function() {
                    rt.event.add(this, e, o, n, t)
                })
            },
            one: function(e, t, n, o) {
                return this.on(e, t, n, o, 1)
            },
            off: function(e, t, n) {
                var o, i;
                if (e && e.preventDefault && e.handleObj) return o = e.handleObj, rt(e.delegateTarget).off(o.namespace ? o.origType + "." + o.namespace : o.origType, o.selector, o.handler), this;
                if ("object" == typeof e) {
                    for (i in e) this.off(i, t, e[i]);
                    return this
                }
                return (t === !1 || "function" == typeof t) && (n = t, t = void 0), n === !1 && (n = f), this.each(function() {
                    rt.event.remove(this, e, n, t)
                })
            },
            trigger: function(e, t) {
                return this.each(function() {
                    rt.event.trigger(e, t, this)
                })
            },
            triggerHandler: function(e, t) {
                var n = this[0];
                return n ? rt.event.trigger(e, t, n, !0) : void 0
            }
        });
        var Ht = "abbr|article|aside|audio|bdi|canvas|data|datalist|details|figcaption|figure|footer|header|hgroup|mark|meter|nav|output|progress|section|summary|time|video",
            Pt = / jQuery\d+="(?:null|\d+)"/g,
            Ot = new RegExp("<(?:" + Ht + ")[\\s/>]", "i"),
            Bt = /^\s+/,
            Ft = /<(?!area|br|col|embed|hr|img|input|link|meta|param)(([\w:]+)[^>]*)\/>/gi,
            qt = /<([\w:]+)/,
            Rt = /<tbody/i,
            Wt = /<|&#?\w+;/,
            Yt = /<(?:script|style|link)/i,
            Xt = /checked\s*(?:[^=]|=\s*.checked.)/i,
            Vt = /^$|\/(?:java|ecma)script/i,
            Ut = /^true\/(.*)/,
            Jt = /^\s*<!(?:\[CDATA\[|--)|(?:\]\]|--)>\s*$/g,
            Qt = {
                option: [1, "<select multiple='multiple'>", "</select>"],
                legend: [1, "<fieldset>", "</fieldset>"],
                area: [1, "<map>", "</map>"],
                param: [1, "<object>", "</object>"],
                thead: [1, "<table>", "</table>"],
                tr: [2, "<table><tbody>", "</tbody></table>"],
                col: [2, "<table><tbody></tbody><colgroup>", "</colgroup></table>"],
                td: [3, "<table><tbody><tr>", "</tr></tbody></table>"],
                _default: ot.htmlSerialize ? [0, "", ""] : [1, "X<div>", "</div>"]
            },
            Kt = m(mt),
            Gt = Kt.appendChild(mt.createElement("div"));
        Qt.optgroup = Qt.option, Qt.tbody = Qt.tfoot = Qt.colgroup = Qt.caption = Qt.thead, Qt.th = Qt.td, rt.extend({
            clone: function(e, t, n) {
                var o, i, r, a, s, l = rt.contains(e.ownerDocument, e);
                if (ot.html5Clone || rt.isXMLDoc(e) || !Ot.test("<" + e.nodeName + ">") ? r = e.cloneNode(!0) : (Gt.innerHTML = e.outerHTML, Gt.removeChild(r = Gt.firstChild)), !(ot.noCloneEvent && ot.noCloneChecked || 1 !== e.nodeType && 11 !== e.nodeType || rt.isXMLDoc(e)))
                    for (o = g(r), s = g(e), a = 0; null != (i = s[a]); ++a) o[a] && _(i, o[a]);
                if (t)
                    if (n)
                        for (s = s || g(e), o = o || g(r), a = 0; null != (i = s[a]); a++) x(i, o[a]);
                    else x(e, r);
                return o = g(r, "script"), o.length > 0 && k(o, !l && g(e, "script")), o = s = i = null, r
            },
            buildFragment: function(e, t, n, o) {
                for (var i, r, a, s, l, u, c, d = e.length, p = m(t), f = [], h = 0; d > h; h++)
                    if (r = e[h], r || 0 === r)
                        if ("object" === rt.type(r)) rt.merge(f, r.nodeType ? [r] : r);
                        else if (Wt.test(r)) {
                            for (s = s || p.appendChild(t.createElement("div")), l = (qt.exec(r) || ["", ""])[1].toLowerCase(), c = Qt[l] || Qt._default, s.innerHTML = c[1] + r.replace(Ft, "<$1></$2>") + c[2], i = c[0]; i--;) s = s.lastChild;
                            if (!ot.leadingWhitespace && Bt.test(r) && f.push(t.createTextNode(Bt.exec(r)[0])), !ot.tbody)
                                for (r = "table" !== l || Rt.test(r) ? "<table>" !== c[1] || Rt.test(r) ? 0 : s : s.firstChild, i = r && r.childNodes.length; i--;) rt.nodeName(u = r.childNodes[i], "tbody") && !u.childNodes.length && r.removeChild(u);
                            for (rt.merge(f, s.childNodes), s.textContent = ""; s.firstChild;) s.removeChild(s.firstChild);
                            s = p.lastChild
                        } else f.push(t.createTextNode(r));
                for (s && p.removeChild(s), ot.appendChecked || rt.grep(g(f, "input"), v), h = 0; r = f[h++];)
                    if ((!o || -1 === rt.inArray(r, o)) && (a = rt.contains(r.ownerDocument, r), s = g(p.appendChild(r), "script"), a && k(s), n))
                        for (i = 0; r = s[i++];) Vt.test(r.type || "") && n.push(r);
                return s = null, p
            },
            cleanData: function(e, t) {
                for (var n, o, i, r, a = 0, s = rt.expando, l = rt.cache, u = ot.deleteExpando, c = rt.event.special; null != (n = e[a]); a++)
                    if ((t || rt.acceptData(n)) && (i = n[s], r = i && l[i])) {
                        if (r.events)
                            for (o in r.events) c[o] ? rt.event.remove(n, o) : rt.removeEvent(n, o, r.handle);
                        l[i] && (delete l[i], u ? delete n[s] : typeof n.removeAttribute !== Ct ? n.removeAttribute(s) : n[s] = null, U.push(i))
                    }
            }
        }), rt.fn.extend({
            text: function(e) {
                return Nt(this, function(e) {
                    return void 0 === e ? rt.text(this) : this.empty().append((this[0] && this[0].ownerDocument || mt).createTextNode(e))
                }, null, e, arguments.length)
            },
            append: function() {
                return this.domManip(arguments, function(e) {
                    if (1 === this.nodeType || 11 === this.nodeType || 9 === this.nodeType) {
                        var t = y(this, e);
                        t.appendChild(e)
                    }
                })
            },
            prepend: function() {
                return this.domManip(arguments, function(e) {
                    if (1 === this.nodeType || 11 === this.nodeType || 9 === this.nodeType) {
                        var t = y(this, e);
                        t.insertBefore(e, t.firstChild)
                    }
                })
            },
            before: function() {
                return this.domManip(arguments, function(e) {
                    this.parentNode && this.parentNode.insertBefore(e, this)
                })
            },
            after: function() {
                return this.domManip(arguments, function(e) {
                    this.parentNode && this.parentNode.insertBefore(e, this.nextSibling)
                })
            },
            remove: function(e, t) {
                for (var n, o = e ? rt.filter(e, this) : this, i = 0; null != (n = o[i]); i++) t || 1 !== n.nodeType || rt.cleanData(g(n)), n.parentNode && (t && rt.contains(n.ownerDocument, n) && k(g(n, "script")), n.parentNode.removeChild(n));
                return this
            },
            empty: function() {
                for (var e, t = 0; null != (e = this[t]); t++) {
                    for (1 === e.nodeType && rt.cleanData(g(e, !1)); e.firstChild;) e.removeChild(e.firstChild);
                    e.options && rt.nodeName(e, "select") && (e.options.length = 0)
                }
                return this
            },
            clone: function(e, t) {
                return e = null == e ? !1 : e, t = null == t ? e : t, this.map(function() {
                    return rt.clone(this, e, t)
                })
            },
            html: function(e) {
                return Nt(this, function(e) {
                    var t = this[0] || {},
                        n = 0,
                        o = this.length;
                    if (void 0 === e) return 1 === t.nodeType ? t.innerHTML.replace(Pt, "") : void 0;
                    if (!("string" != typeof e || Yt.test(e) || !ot.htmlSerialize && Ot.test(e) || !ot.leadingWhitespace && Bt.test(e) || Qt[(qt.exec(e) || ["", ""])[1].toLowerCase()])) {
                        e = e.replace(Ft, "<$1></$2>");
                        try {
                            for (; o > n; n++) t = this[n] || {}, 1 === t.nodeType && (rt.cleanData(g(t, !1)), t.innerHTML = e);
                            t = 0
                        } catch (i) {}
                    }
                    t && this.empty().append(e)
                }, null, e, arguments.length)
            },
            replaceWith: function() {
                var e = arguments[0];
                return this.domManip(arguments, function(t) {
                    e = this.parentNode, rt.cleanData(g(this)), e && e.replaceChild(t, this)
                }), e && (e.length || e.nodeType) ? this : this.remove()
            },
            detach: function(e) {
                return this.remove(e, !0)
            },
            domManip: function(e, t) {
                e = Q.apply([], e);
                var n, o, i, r, a, s, l = 0,
                    u = this.length,
                    c = this,
                    d = u - 1,
                    p = e[0],
                    f = rt.isFunction(p);
                if (f || u > 1 && "string" == typeof p && !ot.checkClone && Xt.test(p)) return this.each(function(n) {
                    var o = c.eq(n);
                    f && (e[0] = p.call(this, n, o.html())), o.domManip(e, t)
                });
                if (u && (s = rt.buildFragment(e, this[0].ownerDocument, !1, this), n = s.firstChild, 1 === s.childNodes.length && (s = n), n)) {
                    for (r = rt.map(g(s, "script"), b), i = r.length; u > l; l++) o = s, l !== d && (o = rt.clone(o, !0, !0), i && rt.merge(r, g(o, "script"))), t.call(this[l], o, l);
                    if (i)
                        for (a = r[r.length - 1].ownerDocument, rt.map(r, w), l = 0; i > l; l++) o = r[l], Vt.test(o.type || "") && !rt._data(o, "globalEval") && rt.contains(a, o) && (o.src ? rt._evalUrl && rt._evalUrl(o.src) : rt.globalEval((o.text || o.textContent || o.innerHTML || "").replace(Jt, "")));
                    s = n = null
                }
                return this
            }
        }), rt.each({
            appendTo: "append",
            prependTo: "prepend",
            insertBefore: "before",
            insertAfter: "after",
            replaceAll: "replaceWith"
        }, function(e, t) {
            rt.fn[e] = function(e) {
                for (var n, o = 0, i = [], r = rt(e), a = r.length - 1; a >= o; o++) n = o === a ? this : this.clone(!0), rt(r[o])[t](n), K.apply(i, n.get());
                return this.pushStack(i)
            }
        });
        var Zt, en = {};
        ! function() {
            var e, t, n = mt.createElement("div"),
                o = "-webkit-box-sizing:content-box;-moz-box-sizing:content-box;box-sizing:content-box;display:block;padding:0;margin:0;border:0";
            n.innerHTML = "  <link/><table></table><a href='/a'>a</a><input type='checkbox'/>", e = n.getElementsByTagName("a")[0], e.style.cssText = "float:left;opacity:.5", ot.opacity = /^0.5/.test(e.style.opacity), ot.cssFloat = !!e.style.cssFloat, n.style.backgroundClip = "content-box", n.cloneNode(!0).style.backgroundClip = "", ot.clearCloneStyle = "content-box" === n.style.backgroundClip, e = n = null, ot.shrinkWrapBlocks = function() {
                var e, n, i, r;
                if (null == t) {
                    if (e = mt.getElementsByTagName("body")[0], !e) return;
                    r = "border:0;width:0;height:0;position:absolute;top:0;left:-9999px", n = mt.createElement("div"), i = mt.createElement("div"), e.appendChild(n).appendChild(i), t = !1, typeof i.style.zoom !== Ct && (i.style.cssText = o + ";width:1px;padding:1px;zoom:1", i.innerHTML = "<div></div>", i.firstChild.style.width = "5px", t = 3 !== i.offsetWidth), e.removeChild(n), e = n = i = null
                }
                return t
            }
        }();
        var tn, nn, on = /^margin/,
            rn = new RegExp("^(" + St + ")(?!px)[a-z%]+$", "i"),
            an = /^(top|right|bottom|left)$/;
        e.getComputedStyle ? (tn = function(e) {
            return e.ownerDocument.defaultView.getComputedStyle(e, null)
        }, nn = function(e, t, n) {
            var o, i, r, a, s = e.style;
            return n = n || tn(e), a = n ? n.getPropertyValue(t) || n[t] : void 0, n && ("" !== a || rt.contains(e.ownerDocument, e) || (a = rt.style(e, t)), rn.test(a) && on.test(t) && (o = s.width, i = s.minWidth, r = s.maxWidth, s.minWidth = s.maxWidth = s.width = a, a = n.width, s.width = o, s.minWidth = i, s.maxWidth = r)), void 0 === a ? a : a + ""
        }) : mt.documentElement.currentStyle && (tn = function(e) {
            return e.currentStyle
        }, nn = function(e, t, n) {
            var o, i, r, a, s = e.style;
            return n = n || tn(e), a = n ? n[t] : void 0, null == a && s && s[t] && (a = s[t]), rn.test(a) && !an.test(t) && (o = s.left, i = e.runtimeStyle, r = i && i.left, r && (i.left = e.currentStyle.left), s.left = "fontSize" === t ? "1em" : a, a = s.pixelLeft + "px", s.left = o, r && (i.left = r)), void 0 === a ? a : a + "" || "auto"
        }),
            function() {
                function t() {
                    var t, n, o = mt.getElementsByTagName("body")[0];
                    o && (t = mt.createElement("div"), n = mt.createElement("div"), t.style.cssText = u, o.appendChild(t).appendChild(n), n.style.cssText = "-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;position:absolute;display:block;padding:1px;border:1px;width:4px;margin-top:1%;top:1%", rt.swap(o, null != o.style.zoom ? {
                        zoom: 1
                    } : {}, function() {
                        i = 4 === n.offsetWidth
                    }), r = !0, a = !1, s = !0, e.getComputedStyle && (a = "1%" !== (e.getComputedStyle(n, null) || {}).top, r = "4px" === (e.getComputedStyle(n, null) || {
                            width: "4px"
                        }).width), o.removeChild(t), n = o = null)
                }
                var n, o, i, r, a, s, l = mt.createElement("div"),
                    u = "border:0;width:0;height:0;position:absolute;top:0;left:-9999px",
                    c = "-webkit-box-sizing:content-box;-moz-box-sizing:content-box;box-sizing:content-box;display:block;padding:0;margin:0;border:0";
                l.innerHTML = "  <link/><table></table><a href='/a'>a</a><input type='checkbox'/>", n = l.getElementsByTagName("a")[0], n.style.cssText = "float:left;opacity:.5", ot.opacity = /^0.5/.test(n.style.opacity), ot.cssFloat = !!n.style.cssFloat, l.style.backgroundClip = "content-box", l.cloneNode(!0).style.backgroundClip = "", ot.clearCloneStyle = "content-box" === l.style.backgroundClip, n = l = null, rt.extend(ot, {
                    reliableHiddenOffsets: function() {
                        if (null != o) return o;
                        var e, t, n, i = mt.createElement("div"),
                            r = mt.getElementsByTagName("body")[0];
                        if (r) return i.setAttribute("className", "t"), i.innerHTML = "  <link/><table></table><a href='/a'>a</a><input type='checkbox'/>", e = mt.createElement("div"), e.style.cssText = u, r.appendChild(e).appendChild(i), i.innerHTML = "<table><tr><td></td><td>t</td></tr></table>", t = i.getElementsByTagName("td"), t[0].style.cssText = "padding:0;margin:0;border:0;display:none", n = 0 === t[0].offsetHeight, t[0].style.display = "", t[1].style.display = "none", o = n && 0 === t[0].offsetHeight, r.removeChild(e), i = r = null, o
                    },
                    boxSizing: function() {
                        return null == i && t(), i
                    },
                    boxSizingReliable: function() {
                        return null == r && t(), r
                    },
                    pixelPosition: function() {
                        return null == a && t(), a
                    },
                    reliableMarginRight: function() {
                        var t, n, o, i;
                        if (null == s && e.getComputedStyle) {
                            if (t = mt.getElementsByTagName("body")[0], !t) return;
                            n = mt.createElement("div"), o = mt.createElement("div"), n.style.cssText = u, t.appendChild(n).appendChild(o), i = o.appendChild(mt.createElement("div")), i.style.cssText = o.style.cssText = c, i.style.marginRight = i.style.width = "0", o.style.width = "1px", s = !parseFloat((e.getComputedStyle(i, null) || {}).marginRight), t.removeChild(n)
                        }
                        return s
                    }
                })
            }(), rt.swap = function(e, t, n, o) {
            var i, r, a = {};
            for (r in t) a[r] = e.style[r], e.style[r] = t[r];
            i = n.apply(e, o || []);
            for (r in t) e.style[r] = a[r];
            return i
        };
        var sn = /alpha\([^)]*\)/i,
            ln = /opacity\s*=\s*([^)]*)/,
            un = /^(none|table(?!-c[ea]).+)/,
            cn = new RegExp("^(" + St + ")(.*)$", "i"),
            dn = new RegExp("^([+-])=(" + St + ")", "i"),
            pn = {
                position: "absolute",
                visibility: "hidden",
                display: "block"
            },
            fn = {
                letterSpacing: 0,
                fontWeight: 400
            },
            hn = ["Webkit", "O", "Moz", "ms"];
        rt.extend({
            cssHooks: {
                opacity: {
                    get: function(e, t) {
                        if (t) {
                            var n = nn(e, "opacity");
                            return "" === n ? "1" : n
                        }
                    }
                }
            },
            cssNumber: {
                columnCount: !0,
                fillOpacity: !0,
                fontWeight: !0,
                lineHeight: !0,
                opacity: !0,
                order: !0,
                orphans: !0,
                widows: !0,
                zIndex: !0,
                zoom: !0
            },
            cssProps: {
                "float": ot.cssFloat ? "cssFloat" : "styleFloat"
            },
            style: function(e, t, n, o) {
                if (e && 3 !== e.nodeType && 8 !== e.nodeType && e.style) {
                    var i, r, a, s = rt.camelCase(t),
                        l = e.style;
                    if (t = rt.cssProps[s] || (rt.cssProps[s] = S(l, s)), a = rt.cssHooks[t] || rt.cssHooks[s], void 0 === n) return a && "get" in a && void 0 !== (i = a.get(e, !1, o)) ? i : l[t];
                    if (r = typeof n, "string" === r && (i = dn.exec(n)) && (n = (i[1] + 1) * i[2] + parseFloat(rt.css(e, t)), r = "number"), null != n && n === n && ("number" !== r || rt.cssNumber[s] || (n += "px"), ot.clearCloneStyle || "" !== n || 0 !== t.indexOf("background") || (l[t] = "inherit"), !(a && "set" in a && void 0 === (n = a.set(e, n, o))))) try {
                        l[t] = "", l[t] = n
                    } catch (u) {}
                }
            },
            css: function(e, t, n, o) {
                var i, r, a, s = rt.camelCase(t);
                return t = rt.cssProps[s] || (rt.cssProps[s] = S(e.style, s)), a = rt.cssHooks[t] || rt.cssHooks[s], a && "get" in a && (r = a.get(e, !0, n)), void 0 === r && (r = nn(e, t, o)), "normal" === r && t in fn && (r = fn[t]), "" === n || n ? (i = parseFloat(r), n === !0 || rt.isNumeric(i) ? i || 0 : r) : r
            }
        }), rt.each(["height", "width"], function(e, t) {
            rt.cssHooks[t] = {
                get: function(e, n, o) {
                    return n ? 0 === e.offsetWidth && un.test(rt.css(e, "display")) ? rt.swap(e, pn, function() {
                        return z(e, t, o)
                    }) : z(e, t, o) : void 0
                },
                set: function(e, n, o) {
                    var i = o && tn(e);
                    return E(e, n, o ? N(e, t, o, ot.boxSizing() && "border-box" === rt.css(e, "boxSizing", !1, i), i) : 0)
                }
            }
        }), ot.opacity || (rt.cssHooks.opacity = {
            get: function(e, t) {
                return ln.test((t && e.currentStyle ? e.currentStyle.filter : e.style.filter) || "") ? .01 * parseFloat(RegExp.$1) + "" : t ? "1" : ""
            },
            set: function(e, t) {
                var n = e.style,
                    o = e.currentStyle,
                    i = rt.isNumeric(t) ? "alpha(opacity=" + 100 * t + ")" : "",
                    r = o && o.filter || n.filter || "";
                n.zoom = 1, (t >= 1 || "" === t) && "" === rt.trim(r.replace(sn, "")) && n.removeAttribute && (n.removeAttribute("filter"), "" === t || o && !o.filter) || (n.filter = sn.test(r) ? r.replace(sn, i) : r + " " + i)
            }
        }), rt.cssHooks.marginRight = j(ot.reliableMarginRight, function(e, t) {
            return t ? rt.swap(e, {
                display: "inline-block"
            }, nn, [e, "marginRight"]) : void 0
        }), rt.each({
            margin: "",
            padding: "",
            border: "Width"
        }, function(e, t) {
            rt.cssHooks[e + t] = {
                expand: function(n) {
                    for (var o = 0, i = {}, r = "string" == typeof n ? n.split(" ") : [n]; 4 > o; o++) i[e + $t[o] + t] = r[o] || r[o - 2] || r[0];
                    return i
                }
            }, on.test(e) || (rt.cssHooks[e + t].set = E)
        }), rt.fn.extend({
            css: function(e, t) {
                return Nt(this, function(e, t, n) {
                    var o, i, r = {},
                        a = 0;
                    if (rt.isArray(t)) {
                        for (o = tn(e), i = t.length; i > a; a++) r[t[a]] = rt.css(e, t[a], !1, o);
                        return r
                    }
                    return void 0 !== n ? rt.style(e, t, n) : rt.css(e, t)
                }, e, t, arguments.length > 1)
            },
            show: function() {
                return $(this, !0)
            },
            hide: function() {
                return $(this)
            },
            toggle: function(e) {
                return "boolean" == typeof e ? e ? this.show() : this.hide() : this.each(function() {
                    Et(this) ? rt(this).show() : rt(this).hide()
                })
            }
        }), rt.Tween = A, A.prototype = {
            constructor: A,
            init: function(e, t, n, o, i, r) {
                this.elem = e, this.prop = n, this.easing = i || "swing", this.options = t, this.start = this.now = this.cur(), this.end = o, this.unit = r || (rt.cssNumber[n] ? "" : "px")
            },
            cur: function() {
                var e = A.propHooks[this.prop];
                return e && e.get ? e.get(this) : A.propHooks._default.get(this)
            },
            run: function(e) {
                var t, n = A.propHooks[this.prop];
                return this.pos = t = this.options.duration ? rt.easing[this.easing](e, this.options.duration * e, 0, 1, this.options.duration) : e, this.now = (this.end - this.start) * t + this.start, this.options.step && this.options.step.call(this.elem, this.now, this), n && n.set ? n.set(this) : A.propHooks._default.set(this), this
            }
        }, A.prototype.init.prototype = A.prototype, A.propHooks = {
            _default: {
                get: function(e) {
                    var t;
                    return null == e.elem[e.prop] || e.elem.style && null != e.elem.style[e.prop] ? (t = rt.css(e.elem, e.prop, ""), t && "auto" !== t ? t : 0) : e.elem[e.prop]
                },
                set: function(e) {
                    rt.fx.step[e.prop] ? rt.fx.step[e.prop](e) : e.elem.style && (null != e.elem.style[rt.cssProps[e.prop]] || rt.cssHooks[e.prop]) ? rt.style(e.elem, e.prop, e.now + e.unit) : e.elem[e.prop] = e.now
                }
            }
        }, A.propHooks.scrollTop = A.propHooks.scrollLeft = {
            set: function(e) {
                e.elem.nodeType && e.elem.parentNode && (e.elem[e.prop] = e.now)
            }
        }, rt.easing = {
            linear: function(e) {
                return e
            },
            swing: function(e) {
                return .5 - Math.cos(e * Math.PI) / 2
            }
        }, rt.fx = A.prototype.init, rt.fx.step = {};
        var mn, gn, vn = /^(?:toggle|show|hide)$/,
            yn = new RegExp("^(?:([+-])=|)(" + St + ")([a-z%]*)$", "i"),
            bn = /queueHooks$/,
            wn = [I],
            kn = {
                "*": [function(e, t) {
                    var n = this.createTween(e, t),
                        o = n.cur(),
                        i = yn.exec(t),
                        r = i && i[3] || (rt.cssNumber[e] ? "" : "px"),
                        a = (rt.cssNumber[e] || "px" !== r && +o) && yn.exec(rt.css(n.elem, e)),
                        s = 1,
                        l = 20;
                    if (a && a[3] !== r) {
                        r = r || a[3], i = i || [], a = +o || 1;
                        do s = s || ".5", a /= s, rt.style(n.elem, e, a + r); while (s !== (s = n.cur() / o) && 1 !== s && --l)
                    }
                    return i && (a = n.start = +a || +o || 0, n.unit = r, n.end = i[1] ? a + (i[1] + 1) * i[2] : +i[2]), n
                }]
            };
        rt.Animation = rt.extend(P, {
            tweener: function(e, t) {
                rt.isFunction(e) ? (t = e, e = ["*"]) : e = e.split(" ");
                for (var n, o = 0, i = e.length; i > o; o++) n = e[o], kn[n] = kn[n] || [], kn[n].unshift(t)
            },
            prefilter: function(e, t) {
                t ? wn.unshift(e) : wn.push(e)
            }
        }), rt.speed = function(e, t, n) {
            var o = e && "object" == typeof e ? rt.extend({}, e) : {
                complete: n || !n && t || rt.isFunction(e) && e,
                duration: e,
                easing: n && t || t && !rt.isFunction(t) && t
            };
            return o.duration = rt.fx.off ? 0 : "number" == typeof o.duration ? o.duration : o.duration in rt.fx.speeds ? rt.fx.speeds[o.duration] : rt.fx.speeds._default, (null == o.queue || o.queue === !0) && (o.queue = "fx"), o.old = o.complete, o.complete = function() {
                rt.isFunction(o.old) && o.old.call(this), o.queue && rt.dequeue(this, o.queue)
            }, o
        }, rt.fn.extend({
            fadeTo: function(e, t, n, o) {
                return this.filter(Et).css("opacity", 0).show().end().animate({
                    opacity: t
                }, e, n, o)
            },
            animate: function(e, t, n, o) {
                var i = rt.isEmptyObject(e),
                    r = rt.speed(t, n, o),
                    a = function() {
                        var t = P(this, rt.extend({}, e), r);
                        (i || rt._data(this, "finish")) && t.stop(!0)
                    };
                return a.finish = a, i || r.queue === !1 ? this.each(a) : this.queue(r.queue, a)
            },
            stop: function(e, t, n) {
                var o = function(e) {
                    var t = e.stop;
                    delete e.stop, t(n)
                };
                return "string" != typeof e && (n = t, t = e, e = void 0), t && e !== !1 && this.queue(e || "fx", []), this.each(function() {
                    var t = !0,
                        i = null != e && e + "queueHooks",
                        r = rt.timers,
                        a = rt._data(this);
                    if (i) a[i] && a[i].stop && o(a[i]);
                    else
                        for (i in a) a[i] && a[i].stop && bn.test(i) && o(a[i]);
                    for (i = r.length; i--;) r[i].elem !== this || null != e && r[i].queue !== e || (r[i].anim.stop(n), t = !1, r.splice(i, 1));
                    (t || !n) && rt.dequeue(this, e)
                })
            },
            finish: function(e) {
                return e !== !1 && (e = e || "fx"), this.each(function() {
                    var t, n = rt._data(this),
                        o = n[e + "queue"],
                        i = n[e + "queueHooks"],
                        r = rt.timers,
                        a = o ? o.length : 0;
                    for (n.finish = !0, rt.queue(this, e, []), i && i.stop && i.stop.call(this, !0), t = r.length; t--;) r[t].elem === this && r[t].queue === e && (r[t].anim.stop(!0), r.splice(t, 1));
                    for (t = 0; a > t; t++) o[t] && o[t].finish && o[t].finish.call(this);
                    delete n.finish
                })
            }
        }), rt.each(["toggle", "show", "hide"], function(e, t) {
            var n = rt.fn[t];
            rt.fn[t] = function(e, o, i) {
                return null == e || "boolean" == typeof e ? n.apply(this, arguments) : this.animate(D(t, !0), e, o, i)
            }
        }), rt.each({
            slideDown: D("show"),
            slideUp: D("hide"),
            slideToggle: D("toggle"),
            fadeIn: {
                opacity: "show"
            },
            fadeOut: {
                opacity: "hide"
            },
            fadeToggle: {
                opacity: "toggle"
            }
        }, function(e, t) {
            rt.fn[e] = function(e, n, o) {
                return this.animate(t, e, n, o)
            }
        }), rt.timers = [], rt.fx.tick = function() {
            var e, t = rt.timers,
                n = 0;
            for (mn = rt.now(); n < t.length; n++) e = t[n], e() || t[n] !== e || t.splice(n--, 1);
            t.length || rt.fx.stop(), mn = void 0
        }, rt.fx.timer = function(e) {
            rt.timers.push(e), e() ? rt.fx.start() : rt.timers.pop()
        }, rt.fx.interval = 13, rt.fx.start = function() {
            gn || (gn = setInterval(rt.fx.tick, rt.fx.interval))
        }, rt.fx.stop = function() {
            clearInterval(gn), gn = null
        }, rt.fx.speeds = {
            slow: 600,
            fast: 200,
            _default: 400
        }, rt.fn.delay = function(e, t) {
            return e = rt.fx ? rt.fx.speeds[e] || e : e, t = t || "fx", this.queue(t, function(t, n) {
                var o = setTimeout(t, e);
                n.stop = function() {
                    clearTimeout(o)
                }
            })
        },
            function() {
                var e, t, n, o, i = mt.createElement("div");
                i.setAttribute("className", "t"), i.innerHTML = "  <link/><table></table><a href='/a'>a</a><input type='checkbox'/>", e = i.getElementsByTagName("a")[0], n = mt.createElement("select"), o = n.appendChild(mt.createElement("option")), t = i.getElementsByTagName("input")[0], e.style.cssText = "top:1px", ot.getSetAttribute = "t" !== i.className, ot.style = /top/.test(e.getAttribute("style")), ot.hrefNormalized = "/a" === e.getAttribute("href"), ot.checkOn = !!t.value, ot.optSelected = o.selected, ot.enctype = !!mt.createElement("form").enctype, n.disabled = !0, ot.optDisabled = !o.disabled, t = mt.createElement("input"), t.setAttribute("value", ""), ot.input = "" === t.getAttribute("value"), t.value = "t", t.setAttribute("type", "radio"), ot.radioValue = "t" === t.value, e = t = n = o = i = null
            }();
        var xn = /\r/g;
        rt.fn.extend({
            val: function(e) {
                var t, n, o, i = this[0]; {
                    if (arguments.length) return o = rt.isFunction(e), this.each(function(n) {
                        var i;
                        1 === this.nodeType && (i = o ? e.call(this, n, rt(this).val()) : e, null == i ? i = "" : "number" == typeof i ? i += "" : rt.isArray(i) && (i = rt.map(i, function(e) {
                            return null == e ? "" : e + ""
                        })), t = rt.valHooks[this.type] || rt.valHooks[this.nodeName.toLowerCase()], t && "set" in t && void 0 !== t.set(this, i, "value") || (this.value = i))
                    });
                    if (i) return t = rt.valHooks[i.type] || rt.valHooks[i.nodeName.toLowerCase()], t && "get" in t && void 0 !== (n = t.get(i, "value")) ? n : (n = i.value, "string" == typeof n ? n.replace(xn, "") : null == n ? "" : n)
                }
            }
        }), rt.extend({
            valHooks: {
                option: {
                    get: function(e) {
                        var t = rt.find.attr(e, "value");
                        return null != t ? t : rt.text(e)
                    }
                },
                select: {
                    get: function(e) {
                        for (var t, n, o = e.options, i = e.selectedIndex, r = "select-one" === e.type || 0 > i, a = r ? null : [], s = r ? i + 1 : o.length, l = 0 > i ? s : r ? i : 0; s > l; l++)
                            if (n = o[l], !(!n.selected && l !== i || (ot.optDisabled ? n.disabled : null !== n.getAttribute("disabled")) || n.parentNode.disabled && rt.nodeName(n.parentNode, "optgroup"))) {
                                if (t = rt(n).val(), r) return t;
                                a.push(t)
                            }
                        return a
                    },
                    set: function(e, t) {
                        for (var n, o, i = e.options, r = rt.makeArray(t), a = i.length; a--;)
                            if (o = i[a], rt.inArray(rt.valHooks.option.get(o), r) >= 0) try {
                                o.selected = n = !0
                            } catch (s) {
                                o.scrollHeight
                            } else o.selected = !1;
                        return n || (e.selectedIndex = -1), i
                    }
                }
            }
        }), rt.each(["radio", "checkbox"], function() {
            rt.valHooks[this] = {
                set: function(e, t) {
                    return rt.isArray(t) ? e.checked = rt.inArray(rt(e).val(), t) >= 0 : void 0
                }
            }, ot.checkOn || (rt.valHooks[this].get = function(e) {
                return null === e.getAttribute("value") ? "on" : e.value
            })
        });
        var _n, Cn, Tn = rt.expr.attrHandle,
            jn = /^(?:checked|selected)$/i,
            Sn = ot.getSetAttribute,
            $n = ot.input;
        rt.fn.extend({
            attr: function(e, t) {
                return Nt(this, rt.attr, e, t, arguments.length > 1)
            },
            removeAttr: function(e) {
                return this.each(function() {
                    rt.removeAttr(this, e)
                })
            }
        }), rt.extend({
            attr: function(e, t, n) {
                var o, i, r = e.nodeType;
                if (e && 3 !== r && 8 !== r && 2 !== r) return typeof e.getAttribute === Ct ? rt.prop(e, t, n) : (1 === r && rt.isXMLDoc(e) || (t = t.toLowerCase(), o = rt.attrHooks[t] || (rt.expr.match.bool.test(t) ? Cn : _n)), void 0 === n ? o && "get" in o && null !== (i = o.get(e, t)) ? i : (i = rt.find.attr(e, t), null == i ? void 0 : i) : null !== n ? o && "set" in o && void 0 !== (i = o.set(e, n, t)) ? i : (e.setAttribute(t, n + ""), n) : (rt.removeAttr(e, t), void 0))
            },
            removeAttr: function(e, t) {
                var n, o, i = 0,
                    r = t && t.match(wt);
                if (r && 1 === e.nodeType)
                    for (; n = r[i++];) o = rt.propFix[n] || n, rt.expr.match.bool.test(n) ? $n && Sn || !jn.test(n) ? e[o] = !1 : e[rt.camelCase("default-" + n)] = e[o] = !1 : rt.attr(e, n, ""), e.removeAttribute(Sn ? n : o)
            },
            attrHooks: {
                type: {
                    set: function(e, t) {
                        if (!ot.radioValue && "radio" === t && rt.nodeName(e, "input")) {
                            var n = e.value;
                            return e.setAttribute("type", t), n && (e.value = n), t
                        }
                    }
                }
            }
        }), Cn = {
            set: function(e, t, n) {
                return t === !1 ? rt.removeAttr(e, n) : $n && Sn || !jn.test(n) ? e.setAttribute(!Sn && rt.propFix[n] || n, n) : e[rt.camelCase("default-" + n)] = e[n] = !0, n
            }
        }, rt.each(rt.expr.match.bool.source.match(/\w+/g), function(e, t) {
            var n = Tn[t] || rt.find.attr;
            Tn[t] = $n && Sn || !jn.test(t) ? function(e, t, o) {
                var i, r;
                return o || (r = Tn[t], Tn[t] = i, i = null != n(e, t, o) ? t.toLowerCase() : null, Tn[t] = r), i
            } : function(e, t, n) {
                return n ? void 0 : e[rt.camelCase("default-" + t)] ? t.toLowerCase() : null
            }
        }), $n && Sn || (rt.attrHooks.value = {
            set: function(e, t, n) {
                return rt.nodeName(e, "input") ? (e.defaultValue = t, void 0) : _n && _n.set(e, t, n)
            }
        }), Sn || (_n = {
            set: function(e, t, n) {
                var o = e.getAttributeNode(n);
                return o || e.setAttributeNode(o = e.ownerDocument.createAttribute(n)), o.value = t += "", "value" === n || t === e.getAttribute(n) ? t : void 0
            }
        }, Tn.id = Tn.name = Tn.coords = function(e, t, n) {
            var o;
            return n ? void 0 : (o = e.getAttributeNode(t)) && "" !== o.value ? o.value : null
        }, rt.valHooks.button = {
            get: function(e, t) {
                var n = e.getAttributeNode(t);
                return n && n.specified ? n.value : void 0
            },
            set: _n.set
        }, rt.attrHooks.contenteditable = {
            set: function(e, t, n) {
                _n.set(e, "" === t ? !1 : t, n)
            }
        }, rt.each(["width", "height"], function(e, t) {
            rt.attrHooks[t] = {
                set: function(e, n) {
                    return "" === n ? (e.setAttribute(t, "auto"), n) : void 0
                }
            }
        })), ot.style || (rt.attrHooks.style = {
            get: function(e) {
                return e.style.cssText || void 0
            },
            set: function(e, t) {
                return e.style.cssText = t + ""
            }
        });
        var En = /^(?:input|select|textarea|button|object)$/i,
            Nn = /^(?:a|area)$/i;
        rt.fn.extend({
            prop: function(e, t) {
                return Nt(this, rt.prop, e, t, arguments.length > 1)
            },
            removeProp: function(e) {
                return e = rt.propFix[e] || e, this.each(function() {
                    try {
                        this[e] = void 0, delete this[e]
                    } catch (t) {}
                })
            }
        }), rt.extend({
            propFix: {
                "for": "htmlFor",
                "class": "className"
            },
            prop: function(e, t, n) {
                var o, i, r, a = e.nodeType;
                if (e && 3 !== a && 8 !== a && 2 !== a) return r = 1 !== a || !rt.isXMLDoc(e), r && (t = rt.propFix[t] || t, i = rt.propHooks[t]), void 0 !== n ? i && "set" in i && void 0 !== (o = i.set(e, n, t)) ? o : e[t] = n : i && "get" in i && null !== (o = i.get(e, t)) ? o : e[t]
            },
            propHooks: {
                tabIndex: {
                    get: function(e) {
                        var t = rt.find.attr(e, "tabindex");
                        return t ? parseInt(t, 10) : En.test(e.nodeName) || Nn.test(e.nodeName) && e.href ? 0 : -1
                    }
                }
            }
        }), ot.hrefNormalized || rt.each(["href", "src"], function(e, t) {
            rt.propHooks[t] = {
                get: function(e) {
                    return e.getAttribute(t, 4)
                }
            }
        }), ot.optSelected || (rt.propHooks.selected = {
            get: function(e) {
                var t = e.parentNode;
                return t && (t.selectedIndex, t.parentNode && t.parentNode.selectedIndex), null
            }
        }), rt.each(["tabIndex", "readOnly", "maxLength", "cellSpacing", "cellPadding", "rowSpan", "colSpan", "useMap", "frameBorder", "contentEditable"], function() {
            rt.propFix[this.toLowerCase()] = this
        }), ot.enctype || (rt.propFix.enctype = "encoding");
        var zn = /[\t\r\n\f]/g;
        rt.fn.extend({
            addClass: function(e) {
                var t, n, o, i, r, a, s = 0,
                    l = this.length,
                    u = "string" == typeof e && e;
                if (rt.isFunction(e)) return this.each(function(t) {
                    rt(this).addClass(e.call(this, t, this.className))
                });
                if (u)
                    for (t = (e || "").match(wt) || []; l > s; s++)
                        if (n = this[s], o = 1 === n.nodeType && (n.className ? (" " + n.className + " ").replace(zn, " ") : " ")) {
                            for (r = 0; i = t[r++];) o.indexOf(" " + i + " ") < 0 && (o += i + " ");
                            a = rt.trim(o), n.className !== a && (n.className = a)
                        }
                return this
            },
            removeClass: function(e) {
                var t, n, o, i, r, a, s = 0,
                    l = this.length,
                    u = 0 === arguments.length || "string" == typeof e && e;
                if (rt.isFunction(e)) return this.each(function(t) {
                    rt(this).removeClass(e.call(this, t, this.className))
                });
                if (u)
                    for (t = (e || "").match(wt) || []; l > s; s++)
                        if (n = this[s], o = 1 === n.nodeType && (n.className ? (" " + n.className + " ").replace(zn, " ") : "")) {
                            for (r = 0; i = t[r++];)
                                for (; o.indexOf(" " + i + " ") >= 0;) o = o.replace(" " + i + " ", " ");
                            a = e ? rt.trim(o) : "", n.className !== a && (n.className = a)
                        }
                return this
            },
            toggleClass: function(e, t) {
                var n = typeof e;
                return "boolean" == typeof t && "string" === n ? t ? this.addClass(e) : this.removeClass(e) : rt.isFunction(e) ? this.each(function(n) {
                    rt(this).toggleClass(e.call(this, n, this.className, t), t)
                }) : this.each(function() {
                    if ("string" === n)
                        for (var t, o = 0, i = rt(this), r = e.match(wt) || []; t = r[o++];) i.hasClass(t) ? i.removeClass(t) : i.addClass(t);
                    else(n === Ct || "boolean" === n) && (this.className && rt._data(this, "__className__", this.className), this.className = this.className || e === !1 ? "" : rt._data(this, "__className__") || "")
                })
            },
            hasClass: function(e) {
                for (var t = " " + e + " ", n = 0, o = this.length; o > n; n++)
                    if (1 === this[n].nodeType && (" " + this[n].className + " ").replace(zn, " ").indexOf(t) >= 0) return !0;
                return !1
            }
        }), rt.each("blur focus focusin focusout load resize scroll unload click dblclick mousedown mouseup mousemove mouseover mouseout mouseenter mouseleave change select submit keydown keypress keyup error contextmenu".split(" "), function(e, t) {
            rt.fn[t] = function(e, n) {
                return arguments.length > 0 ? this.on(t, null, e, n) : this.trigger(t)
            }
        }), rt.fn.extend({
            hover: function(e, t) {
                return this.mouseenter(e).mouseleave(t || e)
            },
            bind: function(e, t, n) {
                return this.on(e, null, t, n)
            },
            unbind: function(e, t) {
                return this.off(e, null, t)
            },
            delegate: function(e, t, n, o) {
                return this.on(t, e, n, o)
            },
            undelegate: function(e, t, n) {
                return 1 === arguments.length ? this.off(e, "**") : this.off(t, e || "**", n)
            }
        });
        var An = rt.now(),
            Ln = /\?/,
            Dn = /(,)|(\[|{)|(}|])|"(?:[^"\\\r\n]|\\["\\\/bfnrt]|\\u[\da-fA-F]{4})*"\s*:?|true|false|null|-?(?!0\d)\d+(?:\.\d+|)(?:[eE][+-]?\d+|)/g;
        rt.parseJSON = function(t) {
            if (e.JSON && e.JSON.parse) return e.JSON.parse(t + "");
            var n, o = null,
                i = rt.trim(t + "");
            return i && !rt.trim(i.replace(Dn, function(e, t, i, r) {
                return n && t && (o = 0), 0 === o ? e : (n = i || t, o += !r - !i, "")
            })) ? Function("return " + i)() : rt.error("Invalid JSON: " + t)
        }, rt.parseXML = function(t) {
            var n, o;
            if (!t || "string" != typeof t) return null;
            try {
                e.DOMParser ? (o = new DOMParser, n = o.parseFromString(t, "text/xml")) : (n = new ActiveXObject("Microsoft.XMLDOM"), n.async = "false", n.loadXML(t))
            } catch (i) {
                n = void 0
            }
            return n && n.documentElement && !n.getElementsByTagName("parsererror").length || rt.error("Invalid XML: " + t), n
        };
        var Mn, In, Hn = /#.*$/,
            Pn = /([?&])_=[^&]*/,
            On = /^(.*?):[ \t]*([^\r\n]*)\r?$/gm,
            Bn = /^(?:about|app|app-storage|.+-extension|file|res|widget):$/,
            Fn = /^(?:GET|HEAD)$/,
            qn = /^\/\//,
            Rn = /^([\w.+-]+:)(?:\/\/(?:[^\/?#]*@|)([^\/?#:]*)(?::(\d+)|)|)/,
            Wn = {},
            Yn = {},
            Xn = "*/".concat("*");
        try {
            In = location.href
        } catch (Vn) {
            In = mt.createElement("a"), In.href = "", In = In.href
        }
        Mn = Rn.exec(In.toLowerCase()) || [], rt.extend({
            active: 0,
            lastModified: {},
            etag: {},
            ajaxSettings: {
                url: In,
                type: "GET",
                isLocal: Bn.test(Mn[1]),
                global: !0,
                processData: !0,
                async: !0,
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                accepts: {
                    "*": Xn,
                    text: "text/plain",
                    html: "text/html",
                    xml: "application/xml, text/xml",
                    json: "application/json, text/javascript"
                },
                contents: {
                    xml: /xml/,
                    html: /html/,
                    json: /json/
                },
                responseFields: {
                    xml: "responseXML",
                    text: "responseText",
                    json: "responseJSON"
                },
                converters: {
                    "* text": String,
                    "text html": !0,
                    "text json": rt.parseJSON,
                    "text xml": rt.parseXML
                },
                flatOptions: {
                    url: !0,
                    context: !0
                }
            },
            ajaxSetup: function(e, t) {
                return t ? F(F(e, rt.ajaxSettings), t) : F(rt.ajaxSettings, e)
            },
            ajaxPrefilter: O(Wn),
            ajaxTransport: O(Yn),
            ajax: function(e, t) {
                function n(e, t, n, o) {
                    var i, c, v, y, w, x = t;
                    2 !== b && (b = 2, s && clearTimeout(s), u = void 0, a = o || "", k.readyState = e > 0 ? 4 : 0, i = e >= 200 && 300 > e || 304 === e, n && (y = q(d, k, n)), y = R(d, y, k, i), i ? (d.ifModified && (w = k.getResponseHeader("Last-Modified"), w && (rt.lastModified[r] = w), w = k.getResponseHeader("etag"), w && (rt.etag[r] = w)), 204 === e || "HEAD" === d.type ? x = "nocontent" : 304 === e ? x = "notmodified" : (x = y.state, c = y.data, v = y.error, i = !v)) : (v = x, (e || !x) && (x = "error", 0 > e && (e = 0))), k.status = e, k.statusText = (t || x) + "", i ? h.resolveWith(p, [c, x, k]) : h.rejectWith(p, [k, x, v]), k.statusCode(g), g = void 0, l && f.trigger(i ? "ajaxSuccess" : "ajaxError", [k, d, i ? c : v]), m.fireWith(p, [k, x]), l && (f.trigger("ajaxComplete", [k, d]), --rt.active || rt.event.trigger("ajaxStop")))
                }
                "object" == typeof e && (t = e, e = void 0), t = t || {};
                var o, i, r, a, s, l, u, c, d = rt.ajaxSetup({}, t),
                    p = d.context || d,
                    f = d.context && (p.nodeType || p.jquery) ? rt(p) : rt.event,
                    h = rt.Deferred(),
                    m = rt.Callbacks("once memory"),
                    g = d.statusCode || {},
                    v = {},
                    y = {},
                    b = 0,
                    w = "canceled",
                    k = {
                        readyState: 0,
                        getResponseHeader: function(e) {
                            var t;
                            if (2 === b) {
                                if (!c)
                                    for (c = {}; t = On.exec(a);) c[t[1].toLowerCase()] = t[2];
                                t = c[e.toLowerCase()]
                            }
                            return null == t ? null : t
                        },
                        getAllResponseHeaders: function() {
                            return 2 === b ? a : null
                        },
                        setRequestHeader: function(e, t) {
                            var n = e.toLowerCase();
                            return b || (e = y[n] = y[n] || e, v[e] = t), this
                        },
                        overrideMimeType: function(e) {
                            return b || (d.mimeType = e), this
                        },
                        statusCode: function(e) {
                            var t;
                            if (e)
                                if (2 > b)
                                    for (t in e) g[t] = [g[t], e[t]];
                                else k.always(e[k.status]);
                            return this
                        },
                        abort: function(e) {
                            var t = e || w;
                            return u && u.abort(t), n(0, t), this
                        }
                    };
                if (h.promise(k).complete = m.add, k.success = k.done, k.error = k.fail, d.url = ((e || d.url || In) + "").replace(Hn, "").replace(qn, Mn[1] + "//"), d.type = t.method || t.type || d.method || d.type, d.dataTypes = rt.trim(d.dataType || "*").toLowerCase().match(wt) || [""], null == d.crossDomain && (o = Rn.exec(d.url.toLowerCase()), d.crossDomain = !(!o || o[1] === Mn[1] && o[2] === Mn[2] && (o[3] || ("http:" === o[1] ? "80" : "443")) === (Mn[3] || ("http:" === Mn[1] ? "80" : "443")))), d.data && d.processData && "string" != typeof d.data && (d.data = rt.param(d.data, d.traditional)), B(Wn, d, t, k), 2 === b) return k;
                l = d.global, l && 0 === rt.active++ && rt.event.trigger("ajaxStart"), d.type = d.type.toUpperCase(), d.hasContent = !Fn.test(d.type), r = d.url, d.hasContent || (d.data && (r = d.url += (Ln.test(r) ? "&" : "?") + d.data, delete d.data), d.cache === !1 && (d.url = Pn.test(r) ? r.replace(Pn, "$1_=" + An++) : r + (Ln.test(r) ? "&" : "?") + "_=" + An++)), d.ifModified && (rt.lastModified[r] && k.setRequestHeader("If-Modified-Since", rt.lastModified[r]), rt.etag[r] && k.setRequestHeader("If-None-Match", rt.etag[r])), (d.data && d.hasContent && d.contentType !== !1 || t.contentType) && k.setRequestHeader("Content-Type", d.contentType), k.setRequestHeader("Accept", d.dataTypes[0] && d.accepts[d.dataTypes[0]] ? d.accepts[d.dataTypes[0]] + ("*" !== d.dataTypes[0] ? ", " + Xn + "; q=0.01" : "") : d.accepts["*"]);
                for (i in d.headers) k.setRequestHeader(i, d.headers[i]);
                if (d.beforeSend && (d.beforeSend.call(p, k, d) === !1 || 2 === b)) return k.abort();
                w = "abort";
                for (i in {
                    success: 1,
                    error: 1,
                    complete: 1
                }) k[i](d[i]);
                if (u = B(Yn, d, t, k)) {
                    k.readyState = 1, l && f.trigger("ajaxSend", [k, d]), d.async && d.timeout > 0 && (s = setTimeout(function() {
                        k.abort("timeout")
                    }, d.timeout));
                    try {
                        b = 1, u.send(v, n)
                    } catch (x) {
                        if (!(2 > b)) throw x;
                        n(-1, x)
                    }
                } else n(-1, "No Transport");
                return k
            },
            getJSON: function(e, t, n) {
                return rt.get(e, t, n, "json")
            },
            getScript: function(e, t) {
                return rt.get(e, void 0, t, "script")
            }
        }), rt.each(["get", "post"], function(e, t) {
            rt[t] = function(e, n, o, i) {
                return rt.isFunction(n) && (i = i || o, o = n, n = void 0), rt.ajax({
                    url: e,
                    type: t,
                    dataType: i,
                    data: n,
                    success: o
                })
            }
        }), rt.each(["ajaxStart", "ajaxStop", "ajaxComplete", "ajaxError", "ajaxSuccess", "ajaxSend"], function(e, t) {
            rt.fn[t] = function(e) {
                return this.on(t, e)
            }
        }), rt._evalUrl = function(e) {
            return rt.ajax({
                url: e,
                type: "GET",
                dataType: "script",
                async: !1,
                global: !1,
                "throws": !0
            })
        }, rt.fn.extend({
            wrapAll: function(e) {
                if (rt.isFunction(e)) return this.each(function(t) {
                    rt(this).wrapAll(e.call(this, t))
                });
                if (this[0]) {
                    var t = rt(e, this[0].ownerDocument).eq(0).clone(!0);
                    this[0].parentNode && t.insertBefore(this[0]), t.map(function() {
                        for (var e = this; e.firstChild && 1 === e.firstChild.nodeType;) e = e.firstChild;
                        return e
                    }).append(this)
                }
                return this
            },
            wrapInner: function(e) {
                return rt.isFunction(e) ? this.each(function(t) {
                    rt(this).wrapInner(e.call(this, t))
                }) : this.each(function() {
                    var t = rt(this),
                        n = t.contents();
                    n.length ? n.wrapAll(e) : t.append(e)
                })
            },
            wrap: function(e) {
                var t = rt.isFunction(e);
                return this.each(function(n) {
                    rt(this).wrapAll(t ? e.call(this, n) : e)
                })
            },
            unwrap: function() {
                return this.parent().each(function() {
                    rt.nodeName(this, "body") || rt(this).replaceWith(this.childNodes)
                }).end()
            }
        }), rt.expr.filters.hidden = function(e) {
            return e.offsetWidth <= 0 && e.offsetHeight <= 0 || !ot.reliableHiddenOffsets() && "none" === (e.style && e.style.display || rt.css(e, "display"))
        }, rt.expr.filters.visible = function(e) {
            return !rt.expr.filters.hidden(e)
        };
        var Un = /%20/g,
            Jn = /\[\]$/,
            Qn = /\r?\n/g,
            Kn = /^(?:submit|button|image|reset|file)$/i,
            Gn = /^(?:input|select|textarea|keygen)/i;
        rt.param = function(e, t) {
            var n, o = [],
                i = function(e, t) {
                    t = rt.isFunction(t) ? t() : null == t ? "" : t, o[o.length] = encodeURIComponent(e) + "=" + encodeURIComponent(t)
                };
            if (void 0 === t && (t = rt.ajaxSettings && rt.ajaxSettings.traditional), rt.isArray(e) || e.jquery && !rt.isPlainObject(e)) rt.each(e, function() {
                i(this.name, this.value)
            });
            else
                for (n in e) W(n, e[n], t, i);
            return o.join("&").replace(Un, "+")
        }, rt.fn.extend({
            serialize: function() {
                return rt.param(this.serializeArray())
            },
            serializeArray: function() {
                return this.map(function() {
                    var e = rt.prop(this, "elements");
                    return e ? rt.makeArray(e) : this
                }).filter(function() {
                    var e = this.type;
                    return this.name && !rt(this).is(":disabled") && Gn.test(this.nodeName) && !Kn.test(e) && (this.checked || !zt.test(e))
                }).map(function(e, t) {
                    var n = rt(this).val();
                    return null == n ? null : rt.isArray(n) ? rt.map(n, function(e) {
                        return {
                            name: t.name,
                            value: e.replace(Qn, "\r\n")
                        }
                    }) : {
                        name: t.name,
                        value: n.replace(Qn, "\r\n")
                    }
                }).get()
            }
        }), rt.ajaxSettings.xhr = void 0 !== e.ActiveXObject ? function() {
            return !this.isLocal && /^(get|post|head|put|delete|options)$/i.test(this.type) && Y() || X()
        } : Y;
        var Zn = 0,
            eo = {},
            to = rt.ajaxSettings.xhr();
        e.ActiveXObject && rt(e).on("unload", function() {
            for (var e in eo) eo[e](void 0, !0)
        }), ot.cors = !!to && "withCredentials" in to, to = ot.ajax = !!to, to && rt.ajaxTransport(function(e) {
            if (!e.crossDomain || ot.cors) {
                var t;
                return {
                    send: function(n, o) {
                        var i, r = e.xhr(),
                            a = ++Zn;
                        if (r.open(e.type, e.url, e.async, e.username, e.password), e.xhrFields)
                            for (i in e.xhrFields) r[i] = e.xhrFields[i];
                        e.mimeType && r.overrideMimeType && r.overrideMimeType(e.mimeType), e.crossDomain || n["X-Requested-With"] || (n["X-Requested-With"] = "XMLHttpRequest");
                        for (i in n) void 0 !== n[i] && r.setRequestHeader(i, n[i] + "");
                        r.send(e.hasContent && e.data || null), t = function(n, i) {
                            var s, l, u;
                            if (t && (i || 4 === r.readyState))
                                if (delete eo[a], t = void 0, r.onreadystatechange = rt.noop, i) 4 !== r.readyState && r.abort();
                                else {
                                    u = {}, s = r.status, "string" == typeof r.responseText && (u.text = r.responseText);
                                    try {
                                        l = r.statusText
                                    } catch (c) {
                                        l = ""
                                    }
                                    s || !e.isLocal || e.crossDomain ? 1223 === s && (s = 204) : s = u.text ? 200 : 404
                                }
                            u && o(s, l, u, r.getAllResponseHeaders())
                        }, e.async ? 4 === r.readyState ? setTimeout(t) : r.onreadystatechange = eo[a] = t : t()
                    },
                    abort: function() {
                        t && t(void 0, !0)
                    }
                }
            }
        }), rt.ajaxSetup({
            accepts: {
                script: "text/javascript, application/javascript, application/ecmascript, application/x-ecmascript"
            },
            contents: {
                script: /(?:java|ecma)script/
            },
            converters: {
                "text script": function(e) {
                    return rt.globalEval(e), e
                }
            }
        }), rt.ajaxPrefilter("script", function(e) {
            void 0 === e.cache && (e.cache = !1), e.crossDomain && (e.type = "GET", e.global = !1)
        }), rt.ajaxTransport("script", function(e) {
            if (e.crossDomain) {
                var t, n = mt.head || rt("head")[0] || mt.documentElement;
                return {
                    send: function(o, i) {
                        t = mt.createElement("script"), t.async = !0, e.scriptCharset && (t.charset = e.scriptCharset), t.src = e.url, t.onload = t.onreadystatechange = function(e, n) {
                            (n || !t.readyState || /loaded|complete/.test(t.readyState)) && (t.onload = t.onreadystatechange = null, t.parentNode && t.parentNode.removeChild(t), t = null, n || i(200, "success"))
                        }, n.insertBefore(t, n.firstChild)
                    },
                    abort: function() {
                        t && t.onload(void 0, !0)
                    }
                }
            }
        });
        var no = [],
            oo = /(=)\?(?=&|$)|\?\?/;
        rt.ajaxSetup({
            jsonp: "callback",
            jsonpCallback: function() {
                var e = no.pop() || rt.expando + "_" + An++;
                return this[e] = !0, e
            }
        }), rt.ajaxPrefilter("json jsonp", function(t, n, o) {
            var i, r, a, s = t.jsonp !== !1 && (oo.test(t.url) ? "url" : "string" == typeof t.data && !(t.contentType || "").indexOf("application/x-www-form-urlencoded") && oo.test(t.data) && "data");
            return s || "jsonp" === t.dataTypes[0] ? (i = t.jsonpCallback = rt.isFunction(t.jsonpCallback) ? t.jsonpCallback() : t.jsonpCallback, s ? t[s] = t[s].replace(oo, "$1" + i) : t.jsonp !== !1 && (t.url += (Ln.test(t.url) ? "&" : "?") + t.jsonp + "=" + i), t.converters["script json"] = function() {
                return a || rt.error(i + " was not called"), a[0]
            }, t.dataTypes[0] = "json", r = e[i], e[i] = function() {
                a = arguments
            }, o.always(function() {
                e[i] = r, t[i] && (t.jsonpCallback = n.jsonpCallback, no.push(i)), a && rt.isFunction(r) && r(a[0]), a = r = void 0
            }), "script") : void 0
        }), rt.parseHTML = function(e, t, n) {
            if (!e || "string" != typeof e) return null;
            "boolean" == typeof t && (n = t, t = !1), t = t || mt;
            var o = pt.exec(e),
                i = !n && [];
            return o ? [t.createElement(o[1])] : (o = rt.buildFragment([e], t, i), i && i.length && rt(i).remove(), rt.merge([], o.childNodes))
        };
        var io = rt.fn.load;
        rt.fn.load = function(e, t, n) {
            if ("string" != typeof e && io) return io.apply(this, arguments);
            var o, i, r, a = this,
                s = e.indexOf(" ");
            return s >= 0 && (o = e.slice(s, e.length), e = e.slice(0, s)), rt.isFunction(t) ? (n = t, t = void 0) : t && "object" == typeof t && (r = "POST"), a.length > 0 && rt.ajax({
                url: e,
                type: r,
                dataType: "html",
                data: t
            }).done(function(e) {
                i = arguments, a.html(o ? rt("<div>").append(rt.parseHTML(e)).find(o) : e)
            }).complete(n && function(e, t) {
                    a.each(n, i || [e.responseText, t, e])
                }), this
        }, rt.expr.filters.animated = function(e) {
            return rt.grep(rt.timers, function(t) {
                return e === t.elem
            }).length
        };
        var ro = e.document.documentElement;
        rt.offset = {
            setOffset: function(e, t, n) {
                var o, i, r, a, s, l, u, c = rt.css(e, "position"),
                    d = rt(e),
                    p = {};
                "static" === c && (e.style.position = "relative"), s = d.offset(), r = rt.css(e, "top"), l = rt.css(e, "left"), u = ("absolute" === c || "fixed" === c) && rt.inArray("auto", [r, l]) > -1, u ? (o = d.position(), a = o.top, i = o.left) : (a = parseFloat(r) || 0, i = parseFloat(l) || 0), rt.isFunction(t) && (t = t.call(e, n, s)), null != t.top && (p.top = t.top - s.top + a), null != t.left && (p.left = t.left - s.left + i), "using" in t ? t.using.call(e, p) : d.css(p)
            }
        }, rt.fn.extend({
            offset: function(e) {
                if (arguments.length) return void 0 === e ? this : this.each(function(t) {
                    rt.offset.setOffset(this, e, t)
                });
                var t, n, o = {
                        top: 0,
                        left: 0
                    },
                    i = this[0],
                    r = i && i.ownerDocument;
                if (r) return t = r.documentElement, rt.contains(t, i) ? (typeof i.getBoundingClientRect !== Ct && (o = i.getBoundingClientRect()), n = V(r), {
                    top: o.top + (n.pageYOffset || t.scrollTop) - (t.clientTop || 0),
                    left: o.left + (n.pageXOffset || t.scrollLeft) - (t.clientLeft || 0)
                }) : o
            },
            position: function() {
                if (this[0]) {
                    var e, t, n = {
                            top: 0,
                            left: 0
                        },
                        o = this[0];
                    return "fixed" === rt.css(o, "position") ? t = o.getBoundingClientRect() : (e = this.offsetParent(), t = this.offset(), rt.nodeName(e[0], "html") || (n = e.offset()), n.top += rt.css(e[0], "borderTopWidth", !0), n.left += rt.css(e[0], "borderLeftWidth", !0)), {
                        top: t.top - n.top - rt.css(o, "marginTop", !0),
                        left: t.left - n.left - rt.css(o, "marginLeft", !0)
                    }
                }
            },
            offsetParent: function() {
                return this.map(function() {
                    for (var e = this.offsetParent || ro; e && !rt.nodeName(e, "html") && "static" === rt.css(e, "position");) e = e.offsetParent;
                    return e || ro
                })
            }
        }), rt.each({
            scrollLeft: "pageXOffset",
            scrollTop: "pageYOffset"
        }, function(e, t) {
            var n = /Y/.test(t);
            rt.fn[e] = function(o) {
                return Nt(this, function(e, o, i) {
                    var r = V(e);
                    return void 0 === i ? r ? t in r ? r[t] : r.document.documentElement[o] : e[o] : (r ? r.scrollTo(n ? rt(r).scrollLeft() : i, n ? i : rt(r).scrollTop()) : e[o] = i, void 0)
                }, e, o, arguments.length, null)
            }
        }), rt.each(["top", "left"], function(e, t) {
            rt.cssHooks[t] = j(ot.pixelPosition, function(e, n) {
                return n ? (n = nn(e, t), rn.test(n) ? rt(e).position()[t] + "px" : n) : void 0
            })
        }), rt.each({
            Height: "height",
            Width: "width"
        }, function(e, t) {
            rt.each({
                padding: "inner" + e,
                content: t,
                "": "outer" + e
            }, function(n, o) {
                rt.fn[o] = function(o, i) {
                    var r = arguments.length && (n || "boolean" != typeof o),
                        a = n || (o === !0 || i === !0 ? "margin" : "border");
                    return Nt(this, function(t, n, o) {
                        var i;
                        return rt.isWindow(t) ? t.document.documentElement["client" + e] : 9 === t.nodeType ? (i = t.documentElement, Math.max(t.body["scroll" + e], i["scroll" + e], t.body["offset" + e], i["offset" + e], i["client" + e])) : void 0 === o ? rt.css(t, n, a) : rt.style(t, n, o, a)
                    }, t, r ? o : void 0, r, null)
                }
            })
        }), rt.fn.size = function() {
            return this.length
        }, rt.fn.andSelf = rt.fn.addBack, "function" == typeof define && define.amd && define("jquery", [], function() {
            return rt
        });
        var ao = e.jQuery,
            so = e.$;
        return rt.noConflict = function(t) {
            return e.$ === rt && (e.$ = so), t && e.jQuery === rt && (e.jQuery = ao), rt
        }, typeof t === Ct && (e.jQuery = e.$ = rt), rt
    }),
    function(e, t) {
        function n(e, t, n) {
            var o = d[t.type] || {};
            return null == e ? n || !t.def ? null : t.def : (e = o.floor ? ~~e : parseFloat(e), isNaN(e) ? t.def : o.mod ? (e + o.mod) % o.mod : 0 > e ? 0 : o.max < e ? o.max : e)
        }

        function o(t) {
            var n = u(),
                o = n._rgba = [];
            return t = t.toLowerCase(), h(l, function(e, i) {
                var r, a = i.re.exec(t),
                    s = a && i.parse(a),
                    l = i.space || "rgba";
                return s ? (r = n[l](s), n[c[l].cache] = r[c[l].cache], o = n._rgba = r._rgba, !1) : void 0
            }), o.length ? ("0,0,0,0" === o.join() && e.extend(o, r.transparent), n) : r[t]
        }

        function i(e, t, n) {
            return n = (n + 1) % 1, 1 > 6 * n ? e + (t - e) * n * 6 : 1 > 2 * n ? t : 2 > 3 * n ? e + (t - e) * (2 / 3 - n) * 6 : e
        }
        var r, a = "backgroundColor borderBottomColor borderLeftColor borderRightColor borderTopColor color columnRuleColor outlineColor textDecorationColor textEmphasisColor",
            s = /^([\-+])=\s*(\d+\.?\d*)/,
            l = [{
                re: /rgba?\(\s*(\d{1,3})\s*,\s*(\d{1,3})\s*,\s*(\d{1,3})\s*(?:,\s*(\d?(?:\.\d+)?)\s*)?\)/,
                parse: function(e) {
                    return [e[1], e[2], e[3], e[4]]
                }
            }, {
                re: /rgba?\(\s*(\d+(?:\.\d+)?)\%\s*,\s*(\d+(?:\.\d+)?)\%\s*,\s*(\d+(?:\.\d+)?)\%\s*(?:,\s*(\d?(?:\.\d+)?)\s*)?\)/,
                parse: function(e) {
                    return [2.55 * e[1], 2.55 * e[2], 2.55 * e[3], e[4]]
                }
            }, {
                re: /#([a-f0-9]{2})([a-f0-9]{2})([a-f0-9]{2})/,
                parse: function(e) {
                    return [parseInt(e[1], 16), parseInt(e[2], 16), parseInt(e[3], 16)]
                }
            }, {
                re: /#([a-f0-9])([a-f0-9])([a-f0-9])/,
                parse: function(e) {
                    return [parseInt(e[1] + e[1], 16), parseInt(e[2] + e[2], 16), parseInt(e[3] + e[3], 16)]
                }
            }, {
                re: /hsla?\(\s*(\d+(?:\.\d+)?)\s*,\s*(\d+(?:\.\d+)?)\%\s*,\s*(\d+(?:\.\d+)?)\%\s*(?:,\s*(\d?(?:\.\d+)?)\s*)?\)/,
                space: "hsla",
                parse: function(e) {
                    return [e[1], e[2] / 100, e[3] / 100, e[4]]
                }
            }],
            u = e.Color = function(t, n, o, i) {
                return new e.Color.fn.parse(t, n, o, i)
            },
            c = {
                rgba: {
                    props: {
                        red: {
                            idx: 0,
                            type: "byte"
                        },
                        green: {
                            idx: 1,
                            type: "byte"
                        },
                        blue: {
                            idx: 2,
                            type: "byte"
                        }
                    }
                },
                hsla: {
                    props: {
                        hue: {
                            idx: 0,
                            type: "degrees"
                        },
                        saturation: {
                            idx: 1,
                            type: "percent"
                        },
                        lightness: {
                            idx: 2,
                            type: "percent"
                        }
                    }
                }
            },
            d = {
                "byte": {
                    floor: !0,
                    max: 255
                },
                percent: {
                    max: 1
                },
                degrees: {
                    mod: 360,
                    floor: !0
                }
            },
            p = u.support = {},
            f = e("<p>")[0],
            h = e.each;
        f.style.cssText = "background-color:rgba(1,1,1,.5)", p.rgba = f.style.backgroundColor.indexOf("rgba") > -1, h(c, function(e, t) {
            t.cache = "_" + e, t.props.alpha = {
                idx: 3,
                type: "percent",
                def: 1
            }
        }), u.fn = e.extend(u.prototype, {
            parse: function(i, a, s, l) {
                if (i === t) return this._rgba = [null, null, null, null], this;
                (i.jquery || i.nodeType) && (i = e(i).css(a), a = t);
                var d = this,
                    p = e.type(i),
                    f = this._rgba = [];
                return a !== t && (i = [i, a, s, l], p = "array"), "string" === p ? this.parse(o(i) || r._default) : "array" === p ? (h(c.rgba.props, function(e, t) {
                    f[t.idx] = n(i[t.idx], t)
                }), this) : "object" === p ? (i instanceof u ? h(c, function(e, t) {
                    i[t.cache] && (d[t.cache] = i[t.cache].slice())
                }) : h(c, function(t, o) {
                    var r = o.cache;
                    h(o.props, function(e, t) {
                        if (!d[r] && o.to) {
                            if ("alpha" === e || null == i[e]) return;
                            d[r] = o.to(d._rgba)
                        }
                        d[r][t.idx] = n(i[e], t, !0)
                    }), d[r] && e.inArray(null, d[r].slice(0, 3)) < 0 && (d[r][3] = 1, o.from && (d._rgba = o.from(d[r])))
                }), this) : void 0
            },
            is: function(e) {
                var t = u(e),
                    n = !0,
                    o = this;
                return h(c, function(e, i) {
                    var r, a = t[i.cache];
                    return a && (r = o[i.cache] || i.to && i.to(o._rgba) || [], h(i.props, function(e, t) {
                        return null != a[t.idx] ? n = a[t.idx] === r[t.idx] : void 0
                    })), n
                }), n
            },
            _space: function() {
                var e = [],
                    t = this;
                return h(c, function(n, o) {
                    t[o.cache] && e.push(n)
                }), e.pop()
            },
            transition: function(e, t) {
                var o = u(e),
                    i = o._space(),
                    r = c[i],
                    a = 0 === this.alpha() ? u("transparent") : this,
                    s = a[r.cache] || r.to(a._rgba),
                    l = s.slice();
                return o = o[r.cache], h(r.props, function(e, i) {
                    var r = i.idx,
                        a = s[r],
                        u = o[r],
                        c = d[i.type] || {};
                    null !== u && (null === a ? l[r] = u : (c.mod && (u - a > c.mod / 2 ? a += c.mod : a - u > c.mod / 2 && (a -= c.mod)), l[r] = n((u - a) * t + a, i)))
                }), this[i](l)
            },
            blend: function(t) {
                if (1 === this._rgba[3]) return this;
                var n = this._rgba.slice(),
                    o = n.pop(),
                    i = u(t)._rgba;
                return u(e.map(n, function(e, t) {
                    return (1 - o) * i[t] + o * e
                }))
            },
            toRgbaString: function() {
                var t = "rgba(",
                    n = e.map(this._rgba, function(e, t) {
                        return null == e ? t > 2 ? 1 : 0 : e
                    });
                return 1 === n[3] && (n.pop(), t = "rgb("), t + n.join() + ")"
            },
            toHslaString: function() {
                var t = "hsla(",
                    n = e.map(this.hsla(), function(e, t) {
                        return null == e && (e = t > 2 ? 1 : 0), t && 3 > t && (e = Math.round(100 * e) + "%"), e
                    });
                return 1 === n[3] && (n.pop(), t = "hsl("), t + n.join() + ")"
            },
            toHexString: function(t) {
                var n = this._rgba.slice(),
                    o = n.pop();
                return t && n.push(~~(255 * o)), "#" + e.map(n, function(e) {
                    return e = (e || 0).toString(16), 1 === e.length ? "0" + e : e
                }).join("")
            },
            toString: function() {
                return 0 === this._rgba[3] ? "transparent" : this.toRgbaString()
            }
        }), u.fn.parse.prototype = u.fn, c.hsla.to = function(e) {
            if (null == e[0] || null == e[1] || null == e[2]) return [null, null, null, e[3]];
            var t, n, o = e[0] / 255,
                i = e[1] / 255,
                r = e[2] / 255,
                a = e[3],
                s = Math.max(o, i, r),
                l = Math.min(o, i, r),
                u = s - l,
                c = s + l,
                d = .5 * c;
            return t = l === s ? 0 : o === s ? 60 * (i - r) / u + 360 : i === s ? 60 * (r - o) / u + 120 : 60 * (o - i) / u + 240, n = 0 === u ? 0 : .5 >= d ? u / c : u / (2 - c), [Math.round(t) % 360, n, d, null == a ? 1 : a]
        }, c.hsla.from = function(e) {
            if (null == e[0] || null == e[1] || null == e[2]) return [null, null, null, e[3]];
            var t = e[0] / 360,
                n = e[1],
                o = e[2],
                r = e[3],
                a = .5 >= o ? o * (1 + n) : o + n - o * n,
                s = 2 * o - a;
            return [Math.round(255 * i(s, a, t + 1 / 3)), Math.round(255 * i(s, a, t)), Math.round(255 * i(s, a, t - 1 / 3)), r]
        }, h(c, function(o, i) {
            var r = i.props,
                a = i.cache,
                l = i.to,
                c = i.from;
            u.fn[o] = function(o) {
                if (l && !this[a] && (this[a] = l(this._rgba)), o === t) return this[a].slice();
                var i, s = e.type(o),
                    d = "array" === s || "object" === s ? o : arguments,
                    p = this[a].slice();
                return h(r, function(e, t) {
                    var o = d["object" === s ? e : t.idx];
                    null == o && (o = p[t.idx]), p[t.idx] = n(o, t)
                }), c ? (i = u(c(p)), i[a] = p, i) : u(p)
            }, h(r, function(t, n) {
                u.fn[t] || (u.fn[t] = function(i) {
                    var r, a = e.type(i),
                        l = "alpha" === t ? this._hsla ? "hsla" : "rgba" : o,
                        u = this[l](),
                        c = u[n.idx];
                    return "undefined" === a ? c : ("function" === a && (i = i.call(this, c), a = e.type(i)), null == i && n.empty ? this : ("string" === a && (r = s.exec(i), r && (i = c + parseFloat(r[2]) * ("+" === r[1] ? 1 : -1))), u[n.idx] = i, this[l](u)))
                })
            })
        }), u.hook = function(t) {
            var n = t.split(" ");
            h(n, function(t, n) {
                e.cssHooks[n] = {
                    set: function(t, i) {
                        var r, a, s = "";
                        if ("transparent" !== i && ("string" !== e.type(i) || (r = o(i)))) {
                            if (i = u(r || i), !p.rgba && 1 !== i._rgba[3]) {
                                for (a = "backgroundColor" === n ? t.parentNode : t;
                                     ("" === s || "transparent" === s) && a && a.style;) try {
                                    s = e.css(a, "backgroundColor"), a = a.parentNode
                                } catch (l) {}
                                i = i.blend(s && "transparent" !== s ? s : "_default")
                            }
                            i = i.toRgbaString()
                        }
                        try {
                            t.style[n] = i
                        } catch (l) {}
                    }
                }, e.fx.step[n] = function(t) {
                    t.colorInit || (t.start = u(t.elem, n), t.end = u(t.end), t.colorInit = !0), e.cssHooks[n].set(t.elem, t.start.transition(t.end, t.pos))
                }
            })
        }, u.hook(a), e.cssHooks.borderColor = {
            expand: function(e) {
                var t = {};
                return h(["Top", "Right", "Bottom", "Left"], function(n, o) {
                    t["border" + o + "Color"] = e
                }), t
            }
        }, r = e.Color.names = {
            aqua: "#00ffff",
            black: "#000000",
            blue: "#0000ff",
            fuchsia: "#ff00ff",
            gray: "#808080",
            green: "#008000",
            lime: "#00ff00",
            maroon: "#800000",
            navy: "#000080",
            olive: "#808000",
            purple: "#800080",
            red: "#ff0000",
            silver: "#c0c0c0",
            teal: "#008080",
            white: "#ffffff",
            yellow: "#ffff00",
            transparent: [null, null, null, 0],
            _default: "#ffffff"
        }
    }(jQuery),
    function(e) {
        e.extend(e.easing, {
            def: "easeOutQuad",
            swing: function(t, n, o, i, r) {
                return e.easing[e.easing.def](t, n, o, i, r)
            },
            easeInQuad: function(e, t, n, o, i) {
                return o * (t /= i) * t + n
            },
            easeOutQuad: function(e, t, n, o, i) {
                return -o * (t /= i) * (t - 2) + n
            },
            easeInOutQuad: function(e, t, n, o, i) {
                return (t /= i / 2) < 1 ? o / 2 * t * t + n : -o / 2 * (--t * (t - 2) - 1) + n
            },
            easeInCubic: function(e, t, n, o, i) {
                return o * (t /= i) * t * t + n
            },
            easeOutCubic: function(e, t, n, o, i) {
                return o * ((t = t / i - 1) * t * t + 1) + n
            },
            easeInOutCubic: function(e, t, n, o, i) {
                return (t /= i / 2) < 1 ? o / 2 * t * t * t + n : o / 2 * ((t -= 2) * t * t + 2) + n
            },
            easeInQuart: function(e, t, n, o, i) {
                return o * (t /= i) * t * t * t + n
            },
            easeOutQuart: function(e, t, n, o, i) {
                return -o * ((t = t / i - 1) * t * t * t - 1) + n
            },
            easeInOutQuart: function(e, t, n, o, i) {
                return (t /= i / 2) < 1 ? o / 2 * t * t * t * t + n : -o / 2 * ((t -= 2) * t * t * t - 2) + n
            },
            easeInQuint: function(e, t, n, o, i) {
                return o * (t /= i) * t * t * t * t + n
            },
            easeOutQuint: function(e, t, n, o, i) {
                return o * ((t = t / i - 1) * t * t * t * t + 1) + n
            },
            easeInOutQuint: function(e, t, n, o, i) {
                return (t /= i / 2) < 1 ? o / 2 * t * t * t * t * t + n : o / 2 * ((t -= 2) * t * t * t * t + 2) + n
            },
            easeInSine: function(e, t, n, o, i) {
                return -o * Math.cos(t / i * (Math.PI / 2)) + o + n
            },
            easeOutSine: function(e, t, n, o, i) {
                return o * Math.sin(t / i * (Math.PI / 2)) + n
            },
            easeInOutSine: function(e, t, n, o, i) {
                return -o / 2 * (Math.cos(Math.PI * t / i) - 1) + n
            },
            easeInExpo: function(e, t, n, o, i) {
                return 0 == t ? n : o * Math.pow(2, 10 * (t / i - 1)) + n
            },
            easeOutExpo: function(e, t, n, o, i) {
                return t == i ? n + o : o * (-Math.pow(2, -10 * t / i) + 1) + n
            },
            easeInOutExpo: function(e, t, n, o, i) {
                return 0 == t ? n : t == i ? n + o : (t /= i / 2) < 1 ? o / 2 * Math.pow(2, 10 * (t - 1)) + n : o / 2 * (-Math.pow(2, -10 * --t) + 2) + n
            },
            easeInCirc: function(e, t, n, o, i) {
                return -o * (Math.sqrt(1 - (t /= i) * t) - 1) + n
            },
            easeOutCirc: function(e, t, n, o, i) {
                return o * Math.sqrt(1 - (t = t / i - 1) * t) + n
            },
            easeInOutCirc: function(e, t, n, o, i) {
                return (t /= i / 2) < 1 ? -o / 2 * (Math.sqrt(1 - t * t) - 1) + n : o / 2 * (Math.sqrt(1 - (t -= 2) * t) + 1) + n
            },
            easeInElastic: function(e, t, n, o, i) {
                var r = 1.70158,
                    a = 0,
                    s = o;
                if (0 == t) return n;
                if (1 == (t /= i)) return n + o;
                if (a || (a = .3 * i), s < Math.abs(o)) {
                    s = o;
                    var r = a / 4
                } else var r = a / (2 * Math.PI) * Math.asin(o / s);
                return -(s * Math.pow(2, 10 * (t -= 1)) * Math.sin(2 * (t * i - r) * Math.PI / a)) + n
            },
            easeOutElastic: function(e, t, n, o, i) {
                var r = 1.70158,
                    a = 0,
                    s = o;
                if (0 == t) return n;
                if (1 == (t /= i)) return n + o;
                if (a || (a = .3 * i), s < Math.abs(o)) {
                    s = o;
                    var r = a / 4
                } else var r = a / (2 * Math.PI) * Math.asin(o / s);
                return s * Math.pow(2, -10 * t) * Math.sin(2 * (t * i - r) * Math.PI / a) + o + n
            },
            easeInOutElastic: function(e, t, n, o, i) {
                var r = 1.70158,
                    a = 0,
                    s = o;
                if (0 == t) return n;
                if (2 == (t /= i / 2)) return n + o;
                if (a || (a = .3 * i * 1.5), s < Math.abs(o)) {
                    s = o;
                    var r = a / 4
                } else var r = a / (2 * Math.PI) * Math.asin(o / s);
                return 1 > t ? -.5 * s * Math.pow(2, 10 * (t -= 1)) * Math.sin(2 * (t * i - r) * Math.PI / a) + n : s * Math.pow(2, -10 * (t -= 1)) * Math.sin(2 * (t * i - r) * Math.PI / a) * .5 + o + n
            },
            easeInBack: function(e, t, n, o, i, r) {
                return void 0 == r && (r = 1.70158), o * (t /= i) * t * ((r + 1) * t - r) + n
            },
            easeOutBack: function(e, t, n, o, i, r) {
                return void 0 == r && (r = 1.70158), o * ((t = t / i - 1) * t * ((r + 1) * t + r) + 1) + n
            },
            easeInOutBack: function(e, t, n, o, i, r) {
                return void 0 == r && (r = 1.70158), (t /= i / 2) < 1 ? o / 2 * t * t * (((r *= 1.525) + 1) * t - r) + n : o / 2 * ((t -= 2) * t * (((r *= 1.525) + 1) * t + r) + 2) + n
            },
            easeInBounce: function(t, n, o, i, r) {
                return i - e.easing.easeOutBounce(t, r - n, 0, i, r) + o
            },
            easeOutBounce: function(e, t, n, o, i) {
                return (t /= i) < 1 / 2.75 ? 7.5625 * o * t * t + n : 2 / 2.75 > t ? o * (7.5625 * (t -= 1.5 / 2.75) * t + .75) + n : 2.5 / 2.75 > t ? o * (7.5625 * (t -= 2.25 / 2.75) * t + .9375) + n : o * (7.5625 * (t -= 2.625 / 2.75) * t + .984375) + n
            },
            easeInOutBounce: function(t, n, o, i, r) {
                return r / 2 > n ? .5 * e.easing.easeInBounce(t, 2 * n, 0, i, r) + o : .5 * e.easing.easeOutBounce(t, 2 * n - r, 0, i, r) + .5 * i + o
            }
        })
    }(jQuery), ! function(e) {
    "function" == typeof define && define.amd ? define(["jquery"], e) : "object" == typeof exports ? module.exports = e : e(jQuery)
}(function(e) {
    function t(t) {
        var a = t || window.event,
            s = l.call(arguments, 1),
            u = 0,
            d = 0,
            p = 0,
            f = 0,
            h = 0,
            m = 0;
        if (t = e.event.fix(a), t.type = "mousewheel", "detail" in a && (p = -1 * a.detail), "wheelDelta" in a && (p = a.wheelDelta), "wheelDeltaY" in a && (p = a.wheelDeltaY), "wheelDeltaX" in a && (d = -1 * a.wheelDeltaX), "axis" in a && a.axis === a.HORIZONTAL_AXIS && (d = -1 * p, p = 0), u = 0 === p ? d : p, "deltaY" in a && (p = -1 * a.deltaY, u = p), "deltaX" in a && (d = a.deltaX, 0 === p && (u = -1 * d)), 0 !== p || 0 !== d) {
            if (1 === a.deltaMode) {
                var g = e.data(this, "mousewheel-line-height");
                u *= g, p *= g, d *= g
            } else if (2 === a.deltaMode) {
                var v = e.data(this, "mousewheel-page-height");
                u *= v, p *= v, d *= v
            }
            if (f = Math.max(Math.abs(p), Math.abs(d)), (!r || r > f) && (r = f, o(a, f) && (r /= 40)), o(a, f) && (u /= 40, d /= 40, p /= 40), u = Math[u >= 1 ? "floor" : "ceil"](u / r), d = Math[d >= 1 ? "floor" : "ceil"](d / r), p = Math[p >= 1 ? "floor" : "ceil"](p / r), c.settings.normalizeOffset && this.getBoundingClientRect) {
                var y = this.getBoundingClientRect();
                h = t.clientX - y.left, m = t.clientY - y.top
            }
            return t.deltaX = d, t.deltaY = p, t.deltaFactor = r, t.offsetX = h, t.offsetY = m, t.deltaMode = 0, s.unshift(t, u, d, p), i && clearTimeout(i), i = setTimeout(n, 200), (e.event.dispatch || e.event.handle).apply(this, s)
        }
    }

    function n() {
        r = null
    }

    function o(e, t) {
        return c.settings.adjustOldDeltas && "mousewheel" === e.type && t % 120 === 0
    }
    var i, r, a = ["wheel", "mousewheel", "DOMMouseScroll", "MozMousePixelScroll"],
        s = "onwheel" in document || document.documentMode >= 9 ? ["wheel"] : ["mousewheel", "DomMouseScroll", "MozMousePixelScroll"],
        l = Array.prototype.slice;
    if (e.event.fixHooks)
        for (var u = a.length; u;) e.event.fixHooks[a[--u]] = e.event.mouseHooks;
    var c = e.event.special.mousewheel = {
        version: "3.1.11",
        setup: function() {
            if (this.addEventListener)
                for (var n = s.length; n;) this.addEventListener(s[--n], t, !1);
            else this.onmousewheel = t;
            e.data(this, "mousewheel-line-height", c.getLineHeight(this)), e.data(this, "mousewheel-page-height", c.getPageHeight(this))
        },
        teardown: function() {
            if (this.removeEventListener)
                for (var n = s.length; n;) this.removeEventListener(s[--n], t, !1);
            else this.onmousewheel = null;
            e.removeData(this, "mousewheel-line-height"), e.removeData(this, "mousewheel-page-height")
        },
        getLineHeight: function(t) {
            var n = e(t)["offsetParent" in e.fn ? "offsetParent" : "parent"]();
            return n.length || (n = e("body")), parseInt(n.css("fontSize"), 10)
        },
        getPageHeight: function(t) {
            return e(t).height()
        },
        settings: {
            adjustOldDeltas: !0,
            normalizeOffset: !0
        }
    };
    e.fn.extend({
        mousewheel: function(e) {
            return e ? this.bind("mousewheel", e) : this.trigger("mousewheel")
        },
        unmousewheel: function(e) {
            return this.unbind("mousewheel", e)
        }
    })
}),
    function(e, t, n) {
        function o(t, n) {
            this.element = t, this.settings = e.extend({}, r, n), this._defaults = r, this._name = i, this.init()
        }
        var i = "youtubePopUp",
            r = {
                propertyName: "value"
            };
        o.prototype = {
            init: function() {
                e("#youtubepopup-container").length || this.setupContainer(), this.cacheElements(), this.prepareContent();
                var t = this;
                e(this.element).on("click", function(e) {
                    e.preventDefault(), t.openModal()
                }), this.cached.body.on("click", function() {
                    t.closeModal()
                }), e(n).keyup(function(e) {
                    27 == e.keyCode && t.cached.container.is(":visible") && t.closeModal()
                })
            },
            closeModal: function() {
                this.cached.container.hide(), this.cached.content.prop("src", "").html("")
            },
            openModal: function() {
                var e = this.content;
                this.cached.content.html(e), this.cached.container.css("display", "table")
            },
            prepareContent: function() {
                var t = this.buildVideoURL(e(this.element).attr("href"));
                this.content = '<iframe src="' + t + '?theme=dark&color=red" class="youtube-embed">'
            },
            buildVideoURL: function(e) {
                return e.replace(/(?:http:\/\/)?(?:www\.)?(?:youtube\.com|youtu\.be)\/(?:watch\?v=)?(.+)/g, "www.youtube.com/embed/$1")
            },
            setupContainer: function() {
                var t = '<div id="youtubepopup-container"><div class="popup-body"><div class="popup-close"></div><div class="popup-content"></div></div></div>';
                e("body").append(t)
            },
            cacheElements: function() {
                var t = e("#youtubepopup-container"),
                    n = t.find(".popup-body"),
                    o = t.find(".popup-content");
                this.cached = {
                    container: t,
                    body: n,
                    content: o
                }
            }
        }, e.fn[i] = function(t) {
            return this.each(function() {
                e.data(this, "plugin_" + i) || e.data(this, "plugin_" + i, new o(this, t))
            }), this
        }
    }(jQuery, window, document),
    function() {
        $(".wrap-letters").each(function() {
            var e = $(this).data("wrapclass");
            $(this).children().andSelf().contents().each(function() {
                if (3 == this.nodeType) {
                    var t = $(this);
                    t.replaceWith(t.text().trim().replace(/(.)/g, '<div class="' + e + '">$&</div>'))
                }
            })
        })
    }();
var Device = function() {
    var e = navigator.userAgent,
        t = Math.max(screen.width, screen.height),
        n = Math.min(screen.width, screen.height),
        o = /Mobile/i.test(e),
        i = {
            BlackBerry: /BlackBerry/i.test(e),
            Android: /Android/i.test(e),
            Symbian: /Symbian/i.test(e),
            iPhone: /iPhone/i.test(e),
            WebOS: /WebOS/i.test(e),
            iPod: /iPod/i.test(e),
            iPad: /iPad/i.test(e),
            Windows: /Windows|IEMobile/i.test(e),
            Linux: /Linux/i.test(e),
            Mac: /Mac OS/i.test(e),
            isTouchscreen: /Touch/i.test(e) || !!("ontouchstart" in window),
            isMobile: /iP(hone|od)|BlackBerry|Windows CE|Opera mini|Touch|Mobile/i.test(e),
            isTablet: /Android|iPad|Touch/i.test(e),
            addClasses: function() {
                var e, t, n = document.documentElement;
                if (n) {
                    t = n.className.match(/[^\s\b\t\n\r\f]+/g) || [];
                    for (e in this) "addClasses" != e && (t.indexOf(e) > -1 || this[e] && t.push(e));
                    n.className = t.join(" ")
                }
                return this
            }
        };
    return i.isTablet && i.isMobile && (i.Android && !o ? (i.isTablet = !1, i.isMobile = !0) : (i.isTablet = t > 1e3 && n > 750, i.isMobile = !i.isTablet)), i.addClasses()
}();
$.fn.hasntClass = function(e) {
    return !this.hasClass(e)
};
var isCSSFeatureSupported = function() {
    var e, t = {};
    return function(n) {
        if (n = ("" + n).toLowerCase(), "boolean" == typeof t[n]) return t[n];
        for (e in document.body.style)
            if (e = e.toLowerCase(), e.indexOf(n) >= 0) return t[n] = !0;
        return t[n] = !1
    }
}();
! function() {
    function e(e) {
        "" + e === e && -1 == s.indexOf(e) && s.push(e)
    }

    function t() {
        "function" == typeof a.onUpdate && a.onUpdate(l, s.length), o()
    }

    function n() {
        "function" == typeof a.onFinish && a.onFinish()
    }

    function o() {
        l < s.length ? (r = new Image, r.src = s[l++], r.addEventListener("load", t, !1), r.addEventListener("error", t, !1)) : n()
    }

    function i() {
        delete a.addURL, delete a.addURLs, delete a.start, o()
    }
    var r, a = {
            addURL: function(t) {
                return e(t), this
            },
            addURLs: function(t) {
                if ("object" == typeof t && t.length)
                    for (var n = 0, o = t.length; o > n; n++) e(t[n]);
                return this
            },
            start: function() {
                i()
            },
            onUpdate: null,
            onFinish: null,
            onError: null
        },
        s = [],
        l = 0;
    window.ImagesPreloader = a
}();
var $body = $(document.body);
if (function() {
        function e(e) {
            this.tasks = e || []
        }

        function t(e) {
            if (e.running) return e;
            if (!e.tasks) return e;
            if (!e.tasks[e.current]) return e;
            e.running = !0;
            var t = e.tasks[e.current].task,
                o = e.tasks[e.current].wait;
            return +o !== o && (o = 0), e.timeout = "function" == typeof t ? setTimeout(function() {
                e.running = !1, t(e.current), n(e)
            }, o) : setTimeout(function() {
                e.running = !1, n(e)
            }, o), e
        }

        function n(e) {
            return e.tasks[e.current + 1] ? (e.current++, e.run()) : !e.tasks[e.current + 1] && e.repeating ? (e.reset(), e.run()) : e.stop()
        }
        e.prototype = {
            tasks: [],
            current: 0,
            repeating: !1,
            running: !1,
            timeout: null,
            run: function() {
                return t(this)
            },
            stop: function() {
                return clearTimeout(this.timeout), this.timeout = null, this.running = !1, this
            },
            reset: function(e) {
                return this.stop(), this.current = 0, "function" == typeof e && e(this), this
            }
        }, window.Sequence = e
    }(), function() {
        $.fn.swipeGallery = function(e) {
            function t(e) {
                var t = {
                    x: 0,
                    y: 0
                };
                return e && e.changedTouches && e.changedTouches.length && (t.x = e.changedTouches[0].pageX || 0, t.y = e.changedTouches[0].pageY || 0), t
            }

            function n(e, t) {
                var n, o = ["-webkit-", "-moz-", "-ms-", "-o-", ""],
                    i = {};
                for (n in o) n = o[n] + e, i[n] = t;
                return i
            }

            function o(e, o) {
                e.touched = !0, e.started = !1, e.startPoint = t(o), e.currentPoint = e.startPoint, e.moveFromX = e.$slidesHolder.css("left") || "0", e.moveFromX = e.moveFromX.replace(/[^\d\.\-]/g, ""), e.moveFromX = +e.moveFromX || 0, e.moveFromY = e.$slidesHolder.css("top") || "0", e.moveFromY = e.moveFromY.replace(/[^\d\.\-]/g, ""), e.moveFromY = +e.moveFromY || 0, e.$slidesHolder.css(n("transition-duration", "0s"))
            }

            function i(e, n) {
                e.currentPoint = t(n), e.touched && !e.started && (e.moveByX = Math.abs(e.currentPoint.x - e.startPoint.x), e.moveByY = Math.abs(e.currentPoint.y - e.startPoint.y), e.moveByX > e.moveByY + 6 && (n && n.preventDefault(), e.started = !0, e.startPoint = t(n), e.currentPoint = e.startPoint)), e.started && (n && n.preventDefault(), e.moveByX = e.currentPoint.x - e.startPoint.x, e.$slidesHolder.css("left", e.moveFromX + e.moveByX))
            }

            function r(t, o) {
                o && o.preventDefault(), t.touched && t.started && (t.$slidesHolder.css(n("transition-duration", ".25s")), t.moveByX < 0 && t.curSlide < t.maxSlide && t.curSlide++, t.moveByX > 0 && t.curSlide > 0 && t.curSlide--, t.curSlide != t.prevSlide && "function" == typeof e.onChange && e.onChange(t), t.prevSlide = t.curSlide, t.$slidesHolder.css("left", -(100 * t.curSlide) + "%")), t.touched = !1, t.started = !1
            }
            return e = $.extend({
                slidesHolder: "",
                onResize: null,
                onChange: null
            }, e), this.each(function() {
                var t = {
                    $slidesHolder: null,
                    started: !1,
                    touched: !1,
                    currentPoint: 0,
                    startPoint: 0,
                    moveFromX: 0,
                    moveFromY: 0,
                    moveByX: 0,
                    moveByY: 0,
                    prevSlide: 0,
                    curSlide: 0,
                    maxSlide: 0
                };
                t.$slidesHolder = $(this).find(e.slidesHolder), t.$slidesHolder.css("left", 0), t.maxSlide = t.$slidesHolder.children().length, t.maxSlide = t.maxSlide > 0 ? t.maxSlide - 1 : 0, "function" == typeof e.onResize && ($(window).resize(function() {
                    e.onResize(t), t.curSlide >= t.maxSlide && (t.curSlide = t.maxSlide - 1, r(t))
                }), e.onResize(t)), this.addEventListener("touchcancel", function(e) {
                    r(t, e)
                }), this.addEventListener("touchstart", function(e) {
                    o(t, e)
                }), this.addEventListener("touchmove", function(e) {
                    i(t, e)
                }), this.addEventListener("touchend", function(e) {
                    r(t, e)
                })
            }), this
        }
    }(), function() {
        function e(e, t, n) {
            if (n.running = !1, clearTimeout(n.timeout), !n.running) {
                n.running = !0, n.canEnter = !1, n.previous = 0 > e ? 0 : e, n.current = 0 > t ? 0 : t;
                var o = n.actionsList.length - 1;
                n.previous = e > o ? o : e, n.current = t > o ? o : t, n.actionsList[n.current] && (n.actionsList[n.previous] && n.actionsList[n.previous].exitAction(n.previous, n.current), n.canEnter = !0), n.canEnter ? (n.actionsList[n.current].enterAction && n.actionsList[n.current].enterAction(n.previous, n.current), n.timeout = setTimeout(function() {
                    n.running = !1, n.actionsList[n.current].afterAction(n.previous, n.current)
                }, n.actionsList[n.current].length || 0)) : n.running = !1
            }
        }

        function t(t) {
            t.current < t.actionsList.length && e(t.current, t.current + 1, t)
        }

        function n(t) {
            t.current > 0 && e(t.current, t.current - 1, t)
        }

        function o() {
            var e = this;
            e.actionsList = [], e.initied = !1, e.running = !1, e.canEnter = !1, e.current = 0, e.previous = -1, e.timeout = null
        }
        var i = function() {};
        i.prototype = {
            enterAction: null,
            exitAction: null,
            afterAction: null,
            length: 0
        }, o.prototype = {
            add: function(e) {
                e && e instanceof i && (e.enterAction = e.enterAction || function() {}, e.exitAction = e.exitAction || function() {}, e.afterAction = e.afterAction || function() {}, this.actionsList.push(e))
            },
            "goto": function(t) {
                e(this.current, t, this)
            },
            next: function() {
                t(this)
            },
            prev: function() {
                n(this)
            }
        }, window.Action = i, window.Actions = o
    }(), function() {
        function e(e) {
            "" + e === e && -1 == s.indexOf(e) && s.push(e)
        }

        function t() {
            "function" == typeof a.onUpdate && a.onUpdate(l, s.length), o()
        }

        function n() {
            "function" == typeof a.onFinish && a.onFinish()
        }

        function o() {
            l < s.length ? (r = new Image, r.src = s[l++], r.addEventListener("load", t, !1), r.addEventListener("error", t, !1)) : n()
        }

        function i() {
            delete a.addURL, delete a.addURLs, delete a.start, o()
        }
        var r, a = {
                addURL: function(t) {
                    return e(t), this
                },
                addURLs: function(t) {
                    if ("object" == typeof t && t.length)
                        for (var n = 0, o = t.length; o > n; n++) e(t[n]);
                    return this
                },
                start: function() {
                    i()
                },
                onUpdate: null,
                onFinish: null,
                onError: null
            },
            s = [],
            l = 0;
        window.ImagesPreloader = a
    }(), function() {
        Device.isTouchscreen && Device.isMobile ? (ImagesPreloader.addURLs(["/assets/loading-9c37007470c7c2c4aee1ce7759b0b354.png", "/assets/dirt-5cb5a8839fbdcef327d7d8407cb2583f.png", "/assets/visionare-f9a45a1f32b97edbe0623ae6f5aec40e.png", "/assets/circle-user-48af2db9c3fe371062ab8512645f5ef9.png", "/assets/circle-dream-efa08082900438551bfddc0bb313b5c2.png", "/assets/circle-step-189f689d8e272047e17735934f154294.png", "/assets/circle-magazine-f53f1d57950f0402917c407c0107384b.png", "/assets/circle-community-2b8a7d2c4c073bb567646bddc1e4e80b.png", "/assets/circle-friend-f8044f46b91b58574420a9375615598e.png", "/assets/look_inside-ce839d80f01db20d88bc4ab717066729.png"]), ImagesPreloader.onFinish = function() {
            $("#loading").fadeOut(500), $body.css({
                overflow: "visible"
            })
        }) : (ImagesPreloader.addURLs(["/assets/loading-9c37007470c7c2c4aee1ce7759b0b354.png", "/assets/dirt-5cb5a8839fbdcef327d7d8407cb2583f.png", "/assets/balloon-d8e01d88460a1c088be04b0b967d4510.png", "/assets/bus-8a84eb8f35cee5cac09d9c66d73b0ea6.png", "/assets/car-9b6fde80b2742ed1d93584ae79b1946f.png", "/assets/cloud1-57e8d14f5c359591f7cf7fcdfdfd0ff4.png", "/assets/cloud2-e967c563e8d758796f780b95339be761.png", "/assets/golf-aea5d64c4988929c92d37f656e57b3b8.png", "/assets/ground1-b5cfd89b443454910db06d89d27a5add.png", "/assets/ground2-518f2a45204f1df761b9b201771917c4.png", "/assets/hotdog-873153b24ea83eeadd32d2f1dafa0f11.png", "/assets/house-083b7495c0c779a4c7e1252881f70360.png", "/assets/mountains-4ea9dac7f0174d3a4aa6b198d61ffe02.png", "/assets/rocket-a8213c1a59529a6dff250b6be812ba3e.png", "/assets/school-0bbcff31d7625273dc4fcd1011fcb4e3.png", "/assets/sign-569a08d0841b00291e46bd7b92270848.png", "/assets/skier-8efb14bbf449ba41dfeae7a15164b54b.png", "/assets/sun-8a14cb96226deace3df9201d1824a385.png", "/assets/surfer-3308cddfc36312a4f83a90ee5d6d1345.png", "/assets/tree-068cad6dc62cb881d672f790cc322371.png"]), ImagesPreloader.onFinish = function() {
            $("#loading").fadeOut(500, initIntroAnimations)
        }), ImagesPreloader.start()
    }(), function() {
        $("#sidenav_toggle").click(function() {
            $(this).removeClass("trigger"), $body.addClass("sidenav_visible")
        }), $("#sidenav_close, #main_sections").click(function() {
            $body.removeClass("sidenav_visible")
        })
    }(), function() {
        if (Device.isTouchscreen && Device.isMobile) return !1;
        var e = $("#want_select"),
            t = $("#want_select-icon"),
            n = $("#want_content");
        e.click(function(e) {
            e.stopPropagation(), $(this).toggleClass("open")
        }), $("#main_sections").click(function() {
            e.removeClass("open")
        });
        var o = $("#want_select-items"),
            i = o.find(".want_select-item");
        i.click(function(o) {
            o.preventDefault(), e.html(this.children[1].innerHTML), t.prop("src", this.children[0].src), n.html(this.children[3].innerHTML)
        })
    }(), Device.isTouchscreen && Device.isMobile) {
    $("#section_slides").remove(), $("#lookinside_cols").parent().remove(), $("#iwantto").replaceWith($("#features"));
    var $circles = $("#circles"),
        $circleItems = $circles.find(".circle-item"),
        $circlesSlides = $("#circles-slides"),
        $circlesPoints = $("#circles-slides_points"),
        $circlesPoint = $circlesPoints.children().remove(),
        count = $circleItems.length,
        width;
    $circles.find(".circles-split").remove(), $circlesSlides.append($circleItems), $circles.swipeGallery({
        slidesHolder: "#circles-slides",
        onResize: resizeSlides,
        onChange: changedSlides
    })
} else $("#watch_video").youtubePopUp();
! function() {
    function e(e) {
        var t = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return t.test(e)
    }

    function t(e, t) {
        return ("" + e).replace(/[^\w\d]+/g, "").length >= t
    }
    var n = $("#makeawish-dream"),
        o = $("#makeawish-email"),
        i = $("#makeawish-dream-error"),
        r = $("#makeawish-email-error"),
        a = $("#makeawish-success"),
        s = $("#makeawish-form"),
        l = s.find(".alert-error");
    l.click(function() {
        s.toggleClass("step-b")
    }), $("#makeawish-nextstepBtn").click(function() {
        t(n.val(), 5) ? i.hide(0) : i.show(0), s.toggleClass("step-b")
    }), $("#makeawish-submit").on("click", function(t) {
        e(o.val()) ? (a.html(I18n.t("scripts.sending")).show(0), r.hide(0)) : (t.preventDefault(), a.hide(0), r.show(0)), s.removeClass("step-b")
    }), s.on("keyup keypress", function(e) {
        return 13 == (e.keyCode || e.which) ? (e.preventDefault(), !1) : void 0
    }), s.submit(function(e) {
        e.preventDefault(), $.support.cors = !0, $.ajax({
            url: s.attr("action"),
            type: s.attr("method") || "POST",
            data: s.serialize(),
            crossDomain: !0,
            success: function() {
                a.html(I18n.t("scripts.successfully_sent")).off("click").css({
                    cursor: "default"
                })
            },
            error: function(e) {
                console.log("error:", e), a.hide(0), r.html(I18n.t("scripts.error")).off("click").css({
                    cursor: "default"
                }).show(0)
            }
        })
    })
}();