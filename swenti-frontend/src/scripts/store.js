import {createStore} from "vuex";
import createPersistedState from "vuex-persistedstate";

const store = createStore({
    state() {
        return {
            account: {
                id: ""
            },
            // date:""
        }
    },

    /**
     *  mutations: state를 변경시키는 것이 주목적
     *  비동기 처리가 아닌 동기 처리
     *  commit('함수명','전달 인자') 형태로 실행 시킵니다.
     */
    mutations: {
        setAccount(state, payload) {
            state.account.id = payload;
        },
        clearAccount(state){
            state.account.id="";
        },
        // castDate(state, payload) {
        //     state.date= payload;
        // }
    },

    /**
     * mutations를 실행시키는 것이 주목적
     * 동기 처리가 아닌 비동기 처리를 해야 합니다.
     * dispatch('함수명','전달 인자')로 실행 시킬 수 있습니다.
     */
    actions: {
      login({ commit }, accountId){
          commit('setAccount', accountId);
      },
      logout({ commit }){
          commit('clearAccount');
     },
     //  cast({commit}, date){
     //    commit('castDate', date);
     // }
    },
    plugins: [createPersistedState({
        key: 'my-app',
        paths: ['account']
    })]
})

export default store;
