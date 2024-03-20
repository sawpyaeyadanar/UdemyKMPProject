//
//  ArticleScreen.swift
//  iosApp
//
//  Created by Saw Pyae Yadanar on 15/2/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

extension ArticleScreen {
  @MainActor
  class ArticlesViewModelWrapper: ObservableObject {
    let articlesViewModel: ArticlesViewModel
    @Published var articlesState: ArticlesState
    
    init() {
      self.articlesViewModel = ArticlesInjector().articlesViewModel
      self.articlesState = self.articlesViewModel.articlesState.value
    }
    
    func startObserving() {
      Task {
        for await articlesS in articlesViewModel.articlesState {
          self.articlesState = articlesS
        }
      }
    }
  }
}

struct ArticleScreen: View {
  @ObservedObject private(set) var viewModel: ArticlesViewModelWrapper
    var body: some View {
      VStack {
        AppBar()
        
        if viewModel.articlesState.loading {
          Loader()
        }
        
        if let error = viewModel.articlesState.error {
          ErrorMessage(message: error)
        }
        
        if (!viewModel.articlesState.articles.isEmpty) {
          ScrollView {
            LazyVStack(spacing: 10) {
              ForEach(viewModel.articlesState.articles, id: \.self) { article in
                ArticleItemView(article: article)
              }
            }
          }
        }
      }
      .onAppear {
        self.viewModel.startObserving()
      }
    }
}

struct AppBar: View {
  var body: some View {
    Text("Articles")
      .font(.largeTitle)
      .fontWeight(.bold)
  }
}

struct ArticleItemView: View {
  var article: Article
  var body: some View {
    VStack {
      AsyncImage(url: URL(string: "")) { phase in
        if phase.image != nil {
          phase.image!
            .resizable()
            .aspectRatio(contentMode: .fit)
        } else if phase.error != nil {
          Text("Image Load Error")
        } else {
          ProgressView()
        }
      }
      Text(article.title)
        .font(.title)
        .fontWeight(.bold)
      Text(article.desc)
      Text(article.date)
        .frame(maxWidth: .infinity, alignment: .trailing).foregroundStyle(.gray)
    }
    .padding(16)
  }
}

struct Loader: View {
  var body: some View {
    ProgressView()
  }
}

struct ErrorMessage: View {
  var message: String
  var body: some View {
    Text(message)
      .font(.title)
  }
}
