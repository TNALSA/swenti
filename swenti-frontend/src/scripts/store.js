import {createStore} from "vuex";
import createPersistedState from "vuex-persistedstate";

const store = createStore({
    state() {
        return {
            account: {
                id: ""
            }
        }
    },
    mutations: {
        setAccount(state, payload) {
            state.account.id = payload;
        },
        clearAccount(state){
            state.account.id="";
        }
    },
    actions: {
      login({ commit }, accountId){
          commit('setAccount', accountId);
      },
      logout({ commit }){
          commit('clearAccount');
     }
    },
    plugins: [createPersistedState({
        key: 'my-app',
        paths: ['account']
    })]
})

export default store;
