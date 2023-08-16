import { createStore } from 'vuex'
import {state} from "./state";
import {mutations} from "./mutations";
import {actions} from "./actions";
import {modules} from "./modules";
import createPersistedState from 'vuex-persistedstate'

export default createStore({
    plugins:[createPersistedState({storage: window.sessionStorage})],
    state,
    mutations,
    actions,
    modules
})